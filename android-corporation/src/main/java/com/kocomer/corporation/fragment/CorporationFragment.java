package com.kocomer.corporation.fragment;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.corporation.analysis.CorporationAnalysis;
import com.kocomer.corporation.entity.CorporationEntity;

/**
 * Created by kocomer on 2017/3/26.
 */

public class CorporationFragment extends PageFragment<CorporationEntity> {
    @Override
    public String getPageId() {
        return "corporation";
    }

    @Override
    public String getURL() {
        return "http://192.168.62.107:8080/cells.open";
    }

    @Override
    public Analysis getAnalysis() {
        return new CorporationAnalysis();
    }

    @Override
    public void onPageLoaded(CorporationEntity entity) {

    }
}
