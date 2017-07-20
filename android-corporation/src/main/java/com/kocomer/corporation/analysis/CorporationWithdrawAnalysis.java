package com.kocomer.corporation.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.corporation.entity.CorporationWithdrawEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWithdrawAnalysis implements Analysis<CorporationWithdrawEntity> {
    @Override
    public CorporationWithdrawEntity analysis(JSONObject jsonObject) throws JSONException {
        CorporationWithdrawEntity entity = new CorporationWithdrawEntity();

        return entity;
    }
}
