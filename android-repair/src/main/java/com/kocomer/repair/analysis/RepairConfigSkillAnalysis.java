package com.kocomer.repair.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repair.entity.RepairConfigSkillEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/24.
 */

public class RepairConfigSkillAnalysis implements Analysis<RepairConfigSkillEntity> {
    @Override
    public RepairConfigSkillEntity analysis(JSONObject jsonObject) throws JSONException {
        RepairConfigSkillEntity entity = new RepairConfigSkillEntity();
        return entity;
    }
}
