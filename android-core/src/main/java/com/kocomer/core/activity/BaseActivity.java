package com.kocomer.core.activity;

import android.support.v4.app.FragmentActivity;

import com.umeng.analytics.MobclickAgent;

/**
 * Created by kocomer on 2017/8/28.
 */

public class BaseActivity extends FragmentActivity {
    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }
}
