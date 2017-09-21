package com.kocomer.repair.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repair.entity.RepairTaskEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/21.
 */

public class RepairTaskAnalysis implements Analysis<RepairTaskEntity>{
    @Override
    public RepairTaskEntity analysis(JSONObject jsonObject) throws JSONException {
        return null;
    }
}
