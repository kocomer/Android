package com.kocomer.pay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayScanWechatActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_scanwechat);
    }
}
