package com.kocomer.repair.manager.fragment.config;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.repair.analysis.RepairRealAnalysis;
import com.kocomer.repair.entity.RepairConfigEntity;

/**
 * Created by kocomer on 2017/9/19.
 */

public class RepairConfigFragment extends PageFragment<RepairConfigEntity> {

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
        return new RepairRealAnalysis();
    }

    @Override
    public void onPageLoaded(RepairConfigEntity entity) {

    }
}
