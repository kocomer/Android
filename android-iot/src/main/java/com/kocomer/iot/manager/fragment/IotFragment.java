package com.kocomer.iot.manager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.iot.R;
import com.kocomer.iot.helper.IotConstants;
import com.kocomer.iot.manager.activity.IotRouterActivity;

/**
 * Created by kocomer on 2017/9/12.
 */

public class IotFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Iot";
    }

    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout scancardLinearLayout;

    private ModulesEntity.Module.Cell[] cells;

    public IotFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_iot, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_iot_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("code === " + cell.code);
            switch (cell.code) {
                case IotConstants.CELL_IOT_ROUTER: {//路由管理
                    inflater.inflate(R.layout.fragment_iot_router, contentLayout).findViewById(R.id.fragment_iot_router_ll).setOnClickListener(this);
                }
                break;
            }
        }
        return layout;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_iot_router_ll) {//
            startActivity(new Intent(getActivity(), IotRouterActivity.class));
        }
    }
}