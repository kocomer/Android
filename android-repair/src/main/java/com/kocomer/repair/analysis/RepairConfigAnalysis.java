package com.kocomer.repair.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repair.entity.RepairConfigEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairConfigAnalysis implements Analysis<RepairConfigEntity> {
    @Override
    public RepairConfigEntity analysis(JSONObject jsonObject) throws JSONException {
        RepairConfigEntity entity = new RepairConfigEntity();
        return entity;
    }
}
