package com.kocomer.repair.manager.fragment.config.cells;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageCache;
import com.kocomer.repair.R;
import com.kocomer.repair.analysis.RepairConfigAnalysis;
import com.kocomer.repair.analysis.RepairConfigSkillAnalysis;
import com.kocomer.repair.entity.RepairConfigEntity;
import com.kocomer.repair.entity.RepairConfigSkillEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/24.
 */

public class RepairConfigSkillFragment extends ContentFragment {
    private TextView skillTv;
    private TextView availableTv;
    private ImageLoader imageLoader;

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
        imageLoader = new ImageLoader(queue, new ImageCache());
        View view = inflater.inflate(R.layout.fragment_repair_config_content_skill, null);

        skillTv = (TextView) view.findViewById(R.id.fragment_repair_config_content_skill_tv);
        skillTv.setText(repairConfig.name);

        ImageView imageView = (ImageView) view.findViewById(R.id.fragment_repair_config_content_skill_iv);
        ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, R.drawable.loading, R.drawable.error);
        imageLoader.get(Constants.STR_URL + "/" + repairConfig.img, imageListener);


        availableTv = (TextView) view.findViewById(R.id.fragment_repair_config_content_available_tv);
        if (repairConfig.available) {
            availableTv.setBackgroundResource(R.drawable.switch_selected);
        } else {
            availableTv.setBackgroundResource(R.drawable.switch_normal);
        }
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
            HashMap<String, String> params = new HashMap<>();
            params.put("id", repairConfig.id);
            params.put("available", repairConfig.available ? "1" : "0");
            loadContent(Constants.STR_URL + "/repair_config.json", params, new RepairConfigSkillAnalysis());
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof RepairConfigSkillEntity) {
            RepairConfigSkillEntity repairConfigSkillEntity = (RepairConfigSkillEntity) entity;
            showMsg("修改成功");
        }
    }
}
