package com.kocomer.wechat.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.wechat.R;
import com.kocomer.wechat.fragment.memberlist.WechatMemberListFragment;
import com.kocomer.wechat.fragment.scancard.WechatScanCardFragment;

/**
 * 微信扫描会员卡
 * Created by kocomer on 2017/7/18.
 */

public class WechatScanMemberActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_scanmember);
        String code = this.getIntent().getStringExtra("code");
        if (code != null && !"".equals(code)) {
            WechatScanCardFragment fragment = new WechatScanCardFragment();
            fragment.code = code;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_wechat_scanmember_ll, fragment);
            transaction.commit();
        }
    }

}
