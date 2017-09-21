package com.kocomer.core.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.entity.SuccessEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/20.
 */

public class SuccessAnalysis implements Analysis<SuccessEntity> {
    @Override
    public SuccessEntity analysis(JSONObject jsonObject) throws JSONException {
        SuccessEntity entity = new SuccessEntity();
        return entity;
    }
}
