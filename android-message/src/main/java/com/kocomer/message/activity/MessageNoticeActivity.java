package com.kocomer.message.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.core.activity.BaseActivity;
import com.kocomer.message.R;

/**
 * Created by kocomer on 2017/8/27.
 */

public class MessageNoticeActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_notice);
    }
}
