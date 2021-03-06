package com.kocomer.core.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.analysis.Analysis;
import com.android.volley.toolbox.ObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageHelper;
import com.kocomer.core.helper.SesssionHelper;
import com.kocomer.core.listener.ContentListener;

import java.util.HashMap;
import java.util.Map;

/**
 * 异步请求基类
 */

public abstract class ContentFragment extends BaseFragment implements ContentListener {
    protected RequestQueue queue;

    private AlertDialog.Builder normalDialog;
    private AlertDialog.Builder loadingBuilder;
    private AlertDialog loadingDialog;

    /**
     * 展示加载框
     */
    protected void showLoading() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        loadingBuilder.setTitle("温馨提示");
        loadingDialog = loadingBuilder.setMessage("加载中，请稍后").show();

    }

    /**
     * 取消加载框
     */
    protected void cancelLoading() {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        if (loadingDialog != null && loadingDialog.isShowing()) {
            loadingDialog.dismiss();
        }
    }

    protected void showMsg(String msg) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        System.out.println("getActivity().isFinishing() = " + getActivity().isFinishing());
        normalDialog.setTitle("温馨提示");
        normalDialog.setMessage(msg);
        normalDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        normalDialog.show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(this.getActivity());
        queue.start();
        normalDialog = new AlertDialog.Builder(getActivity());
        loadingBuilder = new AlertDialog.Builder(getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        queue.stop();
    }

    /**
     * @param url
     * @param params
     * @param analysis
     */
    public void loadContent(String url, final HashMap<String, String> params, Analysis analysis) {
        this.loadContent(Request.Method.POST, url, params, null, analysis, ContentFragment.this);
    }

    public void loadContent(String url, Analysis analysis) {
        this.loadContent(Request.Method.POST, url, null, null, analysis, ContentFragment.this);
    }

    public void loadContent(String url, final HashMap<String, String> params, Analysis analysis, ContentListener listener) {
        this.loadContent(Request.Method.POST, url, params, null, analysis, listener);
    }

    public void loadContent(int method, String url, final HashMap<String, String> params, Analysis analysis) {
        this.loadContent(method, url, params, null, analysis, ContentFragment.this);
    }

    public void loadContent(int method, String url, final HashMap<String, String> params, final ImageHelper[] imageHelpers, Analysis analysis, final ContentListener listener) {
        Request<Object> request = new ObjectRequest<Object>(method, url, new Response.Listener<Object>() {
            @Override
            public void onResponse(Object response) {
                listener.onContentAfter();
                listener.onContentLoaded(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.onContentAfter();
                listener.onContentError(error);
            }
        }, analysis) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                if (imageHelpers != null) {
                    for (ImageHelper imageHelper : imageHelpers) {
//                        params.put(imageHelper.name, imageHelper.data);
                    }
                }
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put(Constants.STR_CORPORATIONCODE, Constants.coropratincode);
                headers.put(Constants.STR_PLATFORMFINGER, Constants.platformFinger);
                headers.put(Constants.STR_STOREFINGER, Constants.storeFinger);
                headers.put(Constants.STR_DEVICESESSION, SesssionHelper.getDeviceSession(getActivity()));
                headers.put(Constants.STR_USERSESSION, SesssionHelper.getUserSession(getActivity()));
                return headers;
            }
        };
        onContentBefore();
        queue.add(request);
    }

    @Override
    public void onContentBefore() {
        showLoading();
    }

    @Override
    public void onContentAfter() {
        System.out.println("onContentAfteronContentAfteronContentAfter");
        cancelLoading();
    }

    @Override
    public void onContentLoaded(Object entity) {

    }

    @Override
    public void onContentError(VolleyError error) {
        if (getActivity() == null || getActivity().isFinishing()) {
            return;
        }
        error.printStackTrace();
        switch (error.result) {
            case Constants.RESULT_WARNING: {//

                showMsg(error.message);
            }
            break;
            case Constants.RESULT_REFRESH: {

            }
            break;
            case Constants.RESULT_RELOGIN: {//重新跳转登录页面

            }
            break;
        }

    }
}
