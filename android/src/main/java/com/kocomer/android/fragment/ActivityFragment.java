package com.kocomer.android.fragment;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.analysis.Analysis;
import com.kocomer.android.R;
import com.kocomer.core.analysis.ActivityAnalysis;
import com.kocomer.core.analysis.LoginAnalysis;
import com.kocomer.core.entity.ActivityEntity;
import com.kocomer.core.entity.LoginEntity;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.PageFragment;

import java.util.HashMap;

import static android.content.Context.MODE_PRIVATE;


public class ActivityFragment extends PageFragment<ActivityEntity> {
    private EditText loginNameEt;
    private EditText passwordEt;
    private Button btn1;

    @Override
    public String getPageId() {
        return "activity";
    }

    @Override
    public String getURL() {
        return "http://192.168.62.107:8080/activity.open";
    }

    @Override
    public Analysis getAnalysis() {
        return new ActivityAnalysis();
    }

    private int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_PHONE_STATE)) {

        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_CONTACTS);
        }

        View view = inflater.inflate(R.layout.fragment_main, null);
        loginNameEt = (EditText) view.findViewById(R.id.fragment_main_loginet);
        passwordEt = (EditText) view.findViewById(R.id.fragment_main_passwordet);
        btn1 = (Button) view.findViewById(R.id.fragment_main_btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMsg("test1");
            }
        });
        view.findViewById(R.id.fragment_main_loginbtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> params = new HashMap<>();
                params.put("model", Build.MODEL);

                String imei = ((TelephonyManager) getActivity().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
                params.put("loginName", loginNameEt.getText().toString());
                params.put("password", loginNameEt.getText().toString());
                loadContent("http://192.168.62.107:8080/login.open", params, new LoginAnalysis());
            }
        });
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        System.out.println("oooooooo");
    }

    @Override
    public void onPageLoaded(ActivityEntity entity) {
        System.out.print(entity.deviceSession);
        System.out.println("callback");
    }


    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof LoginEntity) {
            LoginEntity loginEntity = (LoginEntity) entity;
            System.out.println("loginEntity = " + loginEntity.userSession);
            setUserSession(loginEntity.userSession);

            FragmentManager fm = getActivity().getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.remove(this);

            ft.add(R.id.activity_main_content, new ModulesFragment());
            ft.commit();

        }
    }
}
