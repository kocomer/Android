package com.kocomer.android.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.zxing.common.StringUtils;
import com.kocomer.android.R;
import com.kocomer.android.activity.ModulesActivity;
import com.kocomer.core.analysis.LoginAnalysis;
import com.kocomer.core.entity.LoginEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.SesssionHelper;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/8/26.
 */

public class LoginFragment extends ContentFragment implements View.OnClickListener {
    private EditText loginNameEt;
    private EditText passwordEt;

    @Override
    protected String setPageName() {
        return "Login";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, null);
        view.findViewById(R.id.fragment_login_loginbtn).setOnClickListener(this);
        loginNameEt = (EditText) view.findViewById(R.id.fragment_login_loginname_et);
        passwordEt = (EditText) view.findViewById(R.id.fragment_login_password_et);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_login_loginbtn) {
            String loginName = loginNameEt.getText().toString();
            String password = passwordEt.getText().toString();

            HashMap<String, String> params = new HashMap<>();
            params.put("loginName", loginName);
            params.put("password", password);
            loadContent(Constants.STR_URL + "/login.json", params, new LoginAnalysis());
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof LoginEntity) {
            LoginEntity loginEntity = (LoginEntity) entity;
            SesssionHelper.setUserSession(getActivity(), loginEntity.userSession);
            Intent intent = new Intent(getActivity(), ModulesActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }
}
