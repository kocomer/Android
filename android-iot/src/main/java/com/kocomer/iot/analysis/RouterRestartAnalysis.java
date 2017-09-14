package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.RouterBlackEntity;
import com.kocomer.iot.entity.RouterRestartEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/14.
 */

public class RouterRestartAnalysis implements Analysis<RouterRestartEntity> {
    @Override
    public RouterRestartEntity analysis(JSONObject jsonObject) throws JSONException {
        RouterRestartEntity entity = new RouterRestartEntity();
        return entity;
    }
}
