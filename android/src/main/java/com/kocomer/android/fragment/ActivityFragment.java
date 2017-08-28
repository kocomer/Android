package com.kocomer.android.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
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
import android.widget.EditText;

import com.android.volley.analysis.Analysis;
import com.kocomer.android.R;
import com.kocomer.android.activity.LoginActivity;
import com.kocomer.core.analysis.ActivityAnalysis;
import com.kocomer.core.analysis.LoginAnalysis;
import com.kocomer.core.entity.ActivityEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.SesssionHelper;

import java.util.HashMap;

/**
 * 激活登录页面
 */
public class ActivityFragment extends PageFragment<ActivityEntity> {

    @Override
    public String getPageId() {
        return "activity";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/activity.json?imei=test";
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

        View view = inflater.inflate(R.layout.fragment_activity, null);

        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    @Override
    public void onPageLoaded(ActivityEntity entity) {
        System.out.print("entity.deviceSession = " + entity.deviceSession + ":" + getActivity());
        SesssionHelper.setDeviceSession(getActivity(), entity.deviceSession);
        System.out.print(entity.deviceSession);
        System.out.println("callback");
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    protected String setPageName() {
        return "Activity";
    }
}
