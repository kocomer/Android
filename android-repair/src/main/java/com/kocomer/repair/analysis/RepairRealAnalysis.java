package com.kocomer.repair.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repair.entity.RepairRealEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairRealAnalysis implements Analysis<RepairRealEntity> {
    @Override
    public RepairRealEntity analysis(JSONObject jsonObject) throws JSONException {
        RepairRealEntity entity = new RepairRealEntity();
        return entity;
    }
}
