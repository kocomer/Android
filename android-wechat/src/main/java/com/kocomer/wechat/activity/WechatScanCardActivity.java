package com.kocomer.wechat.activity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.core.activity.BaseActivity;
import com.kocomer.wechat.R;
import com.kocomer.wechat.fragment.scancard.WechatScanCardFragment;
import com.kocomer.wechat.fragment.scanmember.WechatScanMemberFragment;

/**
 * 微信扫描营销卡
 * Created by kocomer on 2017/7/18.
 */

public class WechatScanCardActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String code = this.getIntent().getStringExtra("code");
        setContentView(R.layout.activity_wechat_scancard);

        if (code != null && !"".equals(code)) {
            WechatScanCardFragment wechatScanCardFragment = new WechatScanCardFragment();
            wechatScanCardFragment.code = code;
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.activity_wechat_scancard_ll, wechatScanCardFragment);
            transaction.commit();
        }
    }
}
