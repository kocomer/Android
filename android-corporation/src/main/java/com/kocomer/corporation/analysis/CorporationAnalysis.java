package com.kocomer.corporation.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.corporation.entity.CorporationEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/28.
 */

public class CorporationAnalysis implements Analysis<CorporationEntity> {
    @Override
    public CorporationEntity analysis(JSONObject jsonObject) throws JSONException {
        return null;
    }
}
