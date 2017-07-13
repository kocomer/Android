package com.kocomer.core.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ObjectRequest;
import com.android.volley.toolbox.Volley;
import com.kocomer.core.exception.MyAjaxException;
import com.kocomer.core.exception.RelandException;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * 基类
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onClick(View v) {

    }

    /**
     * 处理登录超时异常
     *
     * @param exception
     */
    protected void resolveRelandException(RelandException exception) {
        
    }

    /**
     * 处理异步请求异常
     *
     * @param exception
     */
    protected void resolveMyAjaxException(MyAjaxException exception) {

    }
}
