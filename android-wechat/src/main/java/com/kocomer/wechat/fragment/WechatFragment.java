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
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatAnalysis;
import com.kocomer.wechat.entity.WechatEntity;
import com.kocomer.wechat.fragment.cell.WechatScanMemberFragment;
import com.kocomer.wechat.helper.WechatConstants;

/**
 * Created by kocomer on 2017/3/26.
 */

public class WechatFragment extends ContentFragment implements View.OnClickListener {
    private LinearLayout contentLayout;
    private LinearLayout scanmemberLinearLayout;

    private ModulesEntity.Module.Cell[] cells;

    public void setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat, null);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            switch (cells[i].code) {
                case WechatConstants.CELL_WECHAT_SCANMEMBER: {//微信扫会员卡
                    scanmemberLinearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_scanmember, contentLayout);
                    scanmemberLinearLayout.setOnClickListener(this);
                }
                break;
            }
        }
        return contentLayout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        scanmemberLinearLayout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        System.out.println("vvvv = " + v);
        int i = v.getId();
        if (i == R.id.fragment_wechat_scanmember_ll) {
            System.out.println("scanscanscanscanscanscanscan");
        }
    }
}
