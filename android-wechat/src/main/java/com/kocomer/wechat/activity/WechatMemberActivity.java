package com.kocomer.wechat.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.wechat.R;
import com.kocomer.wechat.fragment.member.WechatMemberFragment;

/**
 * Created by kocomer on 2017/7/18.
 */

public class WechatMemberActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_member);
        String code = this.getIntent().getStringExtra("code");
        if (code != null && !"".equals(code)) {
            WechatMemberFragment fragment = new WechatMemberFragment();
            fragment.code = code;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_wechat_member_ll, fragment);
            transaction.commit();
        }
    }

}
