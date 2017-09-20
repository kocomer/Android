package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.BlackEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/15.
 */

public class BlackAnalysis implements Analysis<BlackEntity> {
    @Override
    public BlackEntity analysis(JSONObject jsonObject) throws JSONException {
        BlackEntity entity = new BlackEntity();
        JSONArray blacksJAry = jsonObject.getJSONArray("blacks");
        int length = blacksJAry.length();
        entity.createBlackDetail(length);
        for (int i = 0; i < length; i++) {
            JSONObject bJObj = blacksJAry.getJSONObject(i);
            entity.blackDetails[i].id = bJObj.getString("id");
            entity.blackDetails[i].cm = bJObj.getString("cm");
            entity.blackDetails[i].date = bJObj.getString("date");
        }

        return entity;
    }
}
