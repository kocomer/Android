package com.kocomer.wechat.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.analysis.Analysis;
import com.google.zxing.client.android.CaptureActivity;
import com.kocomer.core.analysis.CellsAnalysis;
import com.kocomer.core.entity.CellsEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatAnalysis;
import com.kocomer.wechat.entity.WechatEntity;
import com.kocomer.wechat.fragment.cell.WechatScanMemberFragment;

/**
 * Created by kocomer on 2017/3/26.
 */

public class WechatFragment extends PageFragment<CellsEntity> implements View.OnClickListener {
    private LinearLayout contentLayout;
    private RelativeLayout scanmemberLayout;

    @Override
    public String getPageId() {
        return "wechat";
    }

    @Override
    public String getURL() {
        return "http://192.168.62.107:8080/cells.open";
    }

    @Override
    public Analysis getAnalysis() {
        return new CellsAnalysis();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat, null);
        return contentLayout;
    }

    @Override
    public void onPageLoaded(CellsEntity entity) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        for (int i = 0, length = entity.cell.length; i < length; i++) {
            CellsEntity.Cell cell = entity.cell[i];
            if ("wechat_scanmember".equals(cell.code)) {
                WechatScanMemberFragment wechatScanMemberFragment = new WechatScanMemberFragment();
                ft.add(R.id.fragment_wechat_ll, wechatScanMemberFragment);
            }
        }
        ft.commit();
    }

    @Override
    public void onClick(View v) {

    }
}
