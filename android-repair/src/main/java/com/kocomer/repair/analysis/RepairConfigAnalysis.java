package com.kocomer.repair.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repair.entity.RepairConfigEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairConfigAnalysis implements Analysis<RepairConfigEntity> {
    @Override
    public RepairConfigEntity analysis(JSONObject jsonObject) throws JSONException {
        RepairConfigEntity entity = new RepairConfigEntity();
        JSONArray categorysJAry = jsonObject.getJSONArray("categorys");
        int length = categorysJAry.length();
        entity.createRepairConfig(length);
        for (int i = 0; i < length; i++) {
            JSONObject categoryJObj = categorysJAry.getJSONObject(i);
            entity.repairConfigs[i].id = categoryJObj.optString("id");
            entity.repairConfigs[i].name = categoryJObj.optString("name");
            entity.repairConfigs[i].img = categoryJObj.optString("img");
            entity.repairConfigs[i].available = categoryJObj.optBoolean("selected");
        }
        return entity;
    }
}
