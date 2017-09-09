package com.kocomer.android.fragment;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
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
import com.kocomer.android.analysis.CheckVersionAnalysis;
import com.kocomer.android.entity.CheckVersionEntity;
import com.kocomer.core.analysis.ActivityAnalysis;
import com.kocomer.core.analysis.LoginAnalysis;
import com.kocomer.core.entity.ActivityEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.SesssionHelper;

import java.util.HashMap;
import java.util.UUID;

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
        String imei = ((TelephonyManager) getActivity().getSystemService(Activity.TELEPHONY_SERVICE)).getDeviceId();
        return Constants.STR_URL + "/activity.json?imei=" + imei + "&version=" + Constants.version + "&model=" + android.os.Build.MODEL.replace(" ", "");
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
        loadContent(Constants.STR_URL + "/checkVersion.json?&version=" + Constants.version, new CheckVersionAnalysis());
    }

    @Override
    public void onContentLoaded(Object entity) {
        System.out.println(Constants.STR_URL + "/download.apk?corporationCode=" + Constants.coropratincode + "&platformFinger=" + Constants.platformFinger + "&storeFinger=" + Constants.storeFinger + "&deviceSession=" + "&version=" + Constants.version);

        if (entity instanceof CheckVersionEntity) {
            CheckVersionEntity checkVersionEntity = (CheckVersionEntity) entity;
            if (checkVersionEntity.update) {
                new AlertDialog.Builder(getActivity()).setMessage("版本升级").setPositiveButton("升级", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Uri uri = Uri.parse(Constants.STR_URL + "/download.apk?corporationCode=" + Constants.coropratincode + "&platformFinger=" + Constants.platformFinger + "&storeFinger=" + Constants.storeFinger + "&deviceSession=" + "&version=" + Constants.version);   //指定网址
                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);           //指定Action
                        intent.setData(uri);                            //设置Uri
                        startActivity(intent);        //启动Activity
                        getActivity().finish();
                    }
                }).create().show();
            } else {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().finish();
            }

        }
    }

    @Override
    protected String setPageName() {
        return "Activity";
    }
}
