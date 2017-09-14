package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.RouterRestartEntity;
import com.kocomer.iot.entity.RouterShutdownEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/14.
 */

public class RouterShutdownAnalysis implements Analysis<RouterShutdownEntity> {
    @Override
    public RouterShutdownEntity analysis(JSONObject jsonObject) throws JSONException {
        RouterShutdownEntity entity = new RouterShutdownEntity();
        return entity;
    }
}