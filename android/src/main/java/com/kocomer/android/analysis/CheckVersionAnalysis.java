package com.kocomer.android.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.android.entity.CheckVersionEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/29.
 */

public class CheckVersionAnalysis implements Analysis<CheckVersionEntity> {
    @Override
    public CheckVersionEntity analysis(JSONObject jsonObject) throws JSONException {
        CheckVersionEntity checkVersionEntity = new CheckVersionEntity();

        if (jsonObject.optBoolean("update")) {
            checkVersionEntity.update = true;
        }
        return checkVersionEntity;
    }
}
