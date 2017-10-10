package com.kocomer.repair.manager.fragment.config;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.volley.analysis.Analysis;
import com.android.volley.toolbox.ImageLoader;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.repair.R;
import com.kocomer.repair.analysis.RepairConfigAnalysis;
import com.kocomer.repair.analysis.RepairRealAnalysis;
import com.kocomer.repair.entity.RepairConfigEntity;
import com.kocomer.repair.manager.fragment.config.cells.RepairConfigSkillFragment;


/**
 * Created by kocomer on 2017/9/19.
 */

public class RepairConfigFragment extends PageFragment<RepairConfigEntity> {
    private LinearLayout layout;
    private ImageLoader imageLoader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repair_config_content, null);
        layout = (LinearLayout) view.findViewById(R.id.fragment_repair_config_content_ll);
        return view;
    }

    @Override
    protected String setPageName() {
        return "RepairConfig";
    }

    @Override
    public String getPageId() {
        return "RepairConfig";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/repair_config.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new RepairConfigAnalysis();
    }

    @Override
    public void onPageLoaded(final RepairConfigEntity entity) {
        if (entity.repairConfigs != null) {
            for (int i = 0, length = entity.repairConfigs.length; i < length; i++) {
                RepairConfigSkillFragment repairConfigSkillFragment = new RepairConfigSkillFragment();
                repairConfigSkillFragment.setRepairConfig(entity.repairConfigs[i]);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.add(R.id.fragment_repair_config_content_ll, repairConfigSkillFragment);
                fragmentTransaction.commit();
            }
        }
    }
}
