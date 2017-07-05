package com.kocomer.core.fragment;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ObjectRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kocomer on 2017/3/23.
 */

public abstract class BaseFragment extends Fragment {
    private static final String userSessionKey = "userSession";
    private static final String userSessionFile = "userSession";

    protected void setUserSession(String userSession) {
        SharedPreferences share = getActivity().getSharedPreferences(userSessionFile, MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit(); //编辑文件
        edit.putString(userSessionKey, userSession);
        edit.commit();  //保存数据信息
    }

    protected String getUserSession() {
        SharedPreferences share = getActivity().getSharedPreferences(userSessionFile, MODE_PRIVATE);
        return share.getString(userSessionKey, "");
    }
}
