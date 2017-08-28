package com.kocomer.pay.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.core.activity.BaseActivity;
import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/8/17.
 */

public class PayListActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_list);
    }
}