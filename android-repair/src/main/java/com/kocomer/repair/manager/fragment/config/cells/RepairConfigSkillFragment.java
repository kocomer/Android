package com.kocomer.repair.manager.fragment.config.cells;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.repair.R;
import com.kocomer.repair.entity.RepairConfigEntity;

/**
 * Created by kocomer on 2017/9/24.
 */

public class RepairConfigSkillFragment extends ContentFragment {
    private TextView skillTv;
    private TextView availableTv;

    private RepairConfigEntity.RepairConfig repairConfig;

    public void setRepairConfig(RepairConfigEntity.RepairConfig repairConfig) {
        this.repairConfig = repairConfig;
    }

    @Override
    protected String setPageName() {
        return "RepairConfigSkill";
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repair_config_content_skill, null);

        skillTv = (TextView) view.findViewById(R.id.fragment_repair_config_content_skill_tv);

        availableTv = (TextView) view.findViewById(R.id.fragment_repair_config_content_available_tv);
        availableTv.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_repair_config_content_available_tv) {
            if (repairConfig.available) {

                availableTv.setBackgroundResource(R.drawable.switch_normal);
                repairConfig.available = false;
            } else {

                availableTv.setBackgroundResource(R.drawable.switch_selected);
                repairConfig.available = true;
            }

        }
    }
}
