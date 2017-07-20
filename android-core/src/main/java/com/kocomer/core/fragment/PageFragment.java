package com.kocomer.core.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.analysis.Analysis;
import com.android.volley.toolbox.ObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.SesssionHelper;
import com.kocomer.core.listener.PageListener;

import java.util.HashMap;
import java.util.Map;

/**
 * 同步页面基类
 *
 * @param <T>
 */

public abstract class PageFragment<T> extends ContentFragment implements PageListener<T> {
    private boolean refresh;
    private PageListener listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setPageListener(this);

        loadPage();
    }

    private final void loadPage() {
        Request<T> request = new ObjectRequest<T>(Request.Method.GET, getURL(), new Response.Listener<T>() {
            @Override
            public void onResponse(T response) {
                listener.onPageAfter();
                listener.onPageLoaded(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("error ==== " + error + "iii");
                listener.onPageAfter();
                listener.onPageError(error);
            }
        }, getAnalysis()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("pageId", getPageId());
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put(Constants.STR_CORPORATIONCODE, "corporationCode");
                headers.put(Constants.STR_PLATFORMFINGER, "platformFinger");
                headers.put(Constants.STR_DEVICESESSION, "deviceSession");
                headers.put(Constants.STR_USERSESSION, SesssionHelper.getUserSession(getActivity()));
                return headers;
            }
        };
        request.setShouldCache(false);
        onContentBefore();
        queue.add(request);
    }

    protected void setPageListener(PageListener listener) {
        this.listener = listener;
    }

    public abstract String getPageId();

    public abstract String getURL();

    public abstract Analysis getAnalysis();

    public abstract void onPageLoaded(T entity);

    @Override
    public void onPageBefore() {

    }

    @Override
    public void onPageAfter() {

    }

    @Override
    public void onPageError(VolleyError error) {
        showMsg("onPageError 网络错误");
    }


}
