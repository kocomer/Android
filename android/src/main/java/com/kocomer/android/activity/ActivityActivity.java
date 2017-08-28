package com.kocomer.android.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.kocomer.android.R;
import com.kocomer.core.activity.BaseActivity;
import com.umeng.analytics.MobclickAgent;

/**
 * Created by kocomer on 2017/3/23.
 */

public class ActivityActivity extends BaseActivity {
    private LinearLayout contentLayout;
    private ImageView indexIv;
//    private Handler handler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            Intent intent = new Intent(ActivityActivity.this, LoginActivity.class);
//            startActivity(intent);
//            ActivityActivity.this.finish();
//        }
//    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
//        indexIv = (ImageView) findViewById(R.id.activity_main_index_iv);
//        new Thread() {
//            @Override
//            public void run() {
////                try {
////                    Thread.sleep(5000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
//                handler.sendEmptyMessage(1);
//            }
//        }.start();

    }

}
