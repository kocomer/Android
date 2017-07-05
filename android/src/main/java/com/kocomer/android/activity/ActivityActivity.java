package com.kocomer.android.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.kocomer.android.R;
import com.kocomer.android.fragment.ActivityFragment;

/**
 * Created by kocomer on 2017/3/23.
 */

public class ActivityActivity extends Activity {
    private LinearLayout contentLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentLayout = (LinearLayout) findViewById(R.id.activity_main_content);

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.activity_main_content, new ActivityFragment());
        ft.commit();
    }

}
