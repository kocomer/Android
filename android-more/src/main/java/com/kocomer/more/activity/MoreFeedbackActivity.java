package com.kocomer.more.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.kocomer.core.activity.BaseActivity;
import com.kocomer.more.R;

/**
 * Created by kocomer on 2017/8/28.
 */

public class MoreFeedbackActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_more_feedback);
    }
}