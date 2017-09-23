package com.kocomer.repair.manager.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.repair.R;
import com.kocomer.repair.helper.RepairConstants;
import com.kocomer.repair.manager.activity.RepairConfigActivity;
import com.kocomer.repair.manager.activity.RepairEngineerActivity;
import com.kocomer.repair.manager.activity.RepairRealActivity;
import com.kocomer.repair.manager.fragment.task.RepairTaskFragment;

/**
 * Created by kocomer on 2017/9/19.
 */

public class RepairFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Iot";
    }

    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout configLayout;

    private ModulesEntity.Module.Cell[] cells;

    public RepairFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_repair, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_repair_content_ll);
        configLayout = (LinearLayout) layout.findViewById(R.id.fragment_repair_config_position_ll);

        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("cell.code = " + cell.code);
            switch (cell.code) {
                case RepairConstants.CELL_REPAIR_REAL: {//实名认证
                    inflater.inflate(R.layout.fragment_repair_real, contentLayout).findViewById(R.id.fragment_repair_real_ll).setOnClickListener(this);
                }
                break;
                case RepairConstants.CELL_REPAIR_ENGINEER: {//工程师列表
                    inflater.inflate(R.layout.fragment_repair_engineer, contentLayout).findViewById(R.id.fragment_repair_engineer_ll).setOnClickListener(this);
                }
                break;
                case RepairConstants.CELL_REPAIR_CONFIG: {//任务配置
                    inflater.inflate(R.layout.fragment_repair_config, configLayout).findViewById(R.id.fragment_repair_config_ll).setOnClickListener(this);
                }
                break;
                case RepairConstants.CELL_REPAIR_TASK: {//任务列表
                    RepairTaskFragment repairTaskFragment = new RepairTaskFragment();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.add(R.id.fragment_repair_content_ll, repairTaskFragment);
                    ft.commit();
                }
                break;
            }
        }
        return layout;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_repair_real_ll) {//实名制
            startActivity(new Intent(getActivity(), RepairRealActivity.class));
        } else if (i == R.id.fragment_repair_engineer_ll) {//工程师列表
            startActivity(new Intent(getActivity(), RepairEngineerActivity.class));
        } else if (i == R.id.fragment_repair_config_ll) {//配置
            startActivity(new Intent(getActivity(), RepairConfigActivity.class));
        }
    }
}