package com.kocomer.android.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.android.volley.analysis.Analysis;
import com.kocomer.android.R;
import com.kocomer.core.analysis.ModulesAnalysis;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.corporation.fragment.CorporationFragment;
import com.kocomer.corporation.fragment.navigation.CorporationNavigationFragment;
import com.kocomer.wechat.fragment.WechatFragment;
import com.kocomer.wechat.fragment.navigation.WechatNavigationFragment;

/**
 * Created by kocomer on 2017/3/25.
 */

public class ModulesFragment extends PageFragment<ModulesEntity> implements View.OnClickListener {
    private RelativeLayout layout;
    private RelativeLayout footLayout;
    private RelativeLayout headLayout;
    private RelativeLayout wechatNavigationLayout;
    private RelativeLayout corporationNavigationLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (RelativeLayout) inflater.inflate(R.layout.fragment_modules, null);
        footLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_rl);
        headLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_head_rl);
        return layout;
    }

    @Override
    public String getPageId() {
        return "modules";
    }

    @Override
    public String getURL() {
        return "http://192.168.62.107:8080/modules.open";
    }

    @Override
    public Analysis getAnalysis() {
        return new ModulesAnalysis();
    }

    @Override
    public void onPageLoaded(ModulesEntity entity) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        System.out.println("entity = " + entity.module.length);
        for (int i = 0, length = entity.module.length; i < length; i++) {
            ModulesEntity.Module module = entity.module[i];
            System.out.println("cc = " + module.code);
            System.out.println("cclength = " + module.code.length());
            System.out.println("ccltrue = " + "wechat".equals(module.code));

            System.out.println("=====----" + "wechat".equals(module.code));
            if ("wechat".equals(module.code)) {
                WechatNavigationFragment wechatNavigationFragment = new WechatNavigationFragment();
                wechatNavigationFragment.setOnClickListener(this);
                ft.add(R.id.fragment_modules_foot_wechat_rl, wechatNavigationFragment);
            } else if ("corporation".equals(module.code)) {
                CorporationNavigationFragment corporationNavigationFragment = new CorporationNavigationFragment();
                corporationNavigationFragment.setOnClickListener(this);
                ft.add(R.id.fragment_modules_foot_corporation_rl, corporationNavigationFragment);
            }
        }
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.fragment_wechat_navigation_rl: {
                WechatFragment wechatFragment = new WechatFragment();
                ft.replace(R.id.fragment_modules_body_ll, wechatFragment);
            }
            break;
            case R.id.fragment_corporation_navigation_rl: {
                CorporationFragment corporationFragment = new CorporationFragment();
                ft.replace(R.id.fragment_modules_body_ll, corporationFragment);
            }
            break;
        }
        ft.commit();

    }
}
