package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.BlackRemoveEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/15.
 */

public class BlackRemoveAnalysis implements Analysis<BlackRemoveEntity> {
    @Override
    public BlackRemoveEntity analysis(JSONObject jsonObject) throws JSONException {
        BlackRemoveEntity entity = new BlackRemoveEntity();
        return entity;
    }
}
