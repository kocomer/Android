package com.kocomer.wechat.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.wechat.R;

/**
 * 微信扫描营销卡
 * Created by kocomer on 2017/7/18.
 */

public class WechatScanCardActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_scancard);
    }
}
