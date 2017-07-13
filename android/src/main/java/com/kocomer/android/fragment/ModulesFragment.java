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
import com.kocomer.android.helper.Constants;
import com.kocomer.core.analysis.ModulesAnalysis;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.corporation.fragment.CorporationFragment;
import com.kocomer.corporation.fragment.navigation.CorporationNavigationFragment;
import com.kocomer.wechat.fragment.WechatFragment;
import com.kocomer.wechat.fragment.navigation.WechatNavigationFragment;

/**
 * 模块插件
 */
public class ModulesFragment extends PageFragment<ModulesEntity> implements View.OnClickListener {
    private RelativeLayout layout;
    private RelativeLayout footLayout;
    private RelativeLayout headLayout;
    private RelativeLayout wechatNavigationLayout;
    private RelativeLayout corporationNavigationLayout;
    private ModulesEntity modulesEntity;

    private WechatFragment wechatFragment;
    private CorporationFragment corporationFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (RelativeLayout) inflater.inflate(R.layout.fragment_modules, null);
        footLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_rl);
        headLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_head_rl);
        wechatNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_wechat_rl);
        corporationNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_corporation_rl);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        footLayout.setOnClickListener(this);
        headLayout.setOnClickListener(this);
        wechatNavigationLayout.setOnClickListener(this);
        corporationNavigationLayout.setOnClickListener(this);
    }

    @Override
    public String getPageId() {
        return "modules";
    }

    @Override
    public String getURL() {
        return com.kocomer.core.helper.Constants.STR_URL + "/modules.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new ModulesAnalysis();
    }

    @Override
    public void onPageLoaded(ModulesEntity entity) {
        modulesEntity = entity;
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        for (int i = 0, length = entity.module.length; i < length; i++) {
            ModulesEntity.Module module = entity.module[i];
            if (Constants.MODULE_WECHAT.equals(module.code)) {//微信营销模块
                wechatFragment = new WechatFragment();
                wechatFragment.setCells(getCells(entity, Constants.MODULE_WECHAT));
                wechatNavigationLayout.setVisibility(View.VISIBLE);
                WechatNavigationFragment wechatNavigationFragment = new WechatNavigationFragment();
                ft.add(R.id.fragment_modules_foot_wechat_rl, wechatNavigationFragment);
            } else if (Constants.MODULE_CORPORATION.equals(module.code)) {//公司中心
                corporationFragment = new CorporationFragment();
                corporationFragment.setCells(getCells(entity, Constants.MODULE_CORPORATION));
                corporationNavigationLayout.setVisibility(View.VISIBLE);
                CorporationNavigationFragment corporationNavigationFragment = new CorporationNavigationFragment();
                ft.add(R.id.fragment_modules_foot_corporation_rl, corporationNavigationFragment);
            }
        }
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        switch (v.getId()) {
            case R.id.fragment_modules_foot_wechat_rl: {
                ft.replace(R.id.fragment_modules_body_ll, wechatFragment);
            }
            break;
            case R.id.fragment_modules_foot_corporation_rl: {
                corporationFragment.setCells(getCells(modulesEntity, Constants.MODULE_CORPORATION));
                ft.replace(R.id.fragment_modules_body_ll, corporationFragment);
            }

            break;
        }
        ft.commit();

    }

    private ModulesEntity.Module.Cell[] getCells(ModulesEntity modulesEntity, String code) {
        int length = modulesEntity.module.length;
        for (int i = 0; i < length; i++) {
            if (code.equals(modulesEntity.module[i].code)) {
                return modulesEntity.module[i].cells;
            }
        }
        return null;
    }
}
