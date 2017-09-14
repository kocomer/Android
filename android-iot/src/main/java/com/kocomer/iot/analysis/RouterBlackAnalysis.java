package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.RouterBlackEntity;
import com.kocomer.iot.entity.RouterEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/14.
 */

public class RouterBlackAnalysis implements Analysis<RouterBlackEntity> {
    @Override
    public RouterBlackEntity analysis(JSONObject jsonObject) throws JSONException {
        RouterBlackEntity entity = new RouterBlackEntity();
        return entity;
    }
}
