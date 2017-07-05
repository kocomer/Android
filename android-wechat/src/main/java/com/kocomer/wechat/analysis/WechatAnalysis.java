package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/28.
 */

public class WechatAnalysis implements Analysis<WechatEntity> {
    @Override
    public WechatEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray cellsJAry = jsonObject.getJSONArray("cells");
        int length = cellsJAry.length();

        for (int i = 0; i < length; i++) {
            JSONObject jObj = cellsJAry.getJSONObject(i);
            jObj.getString("");
        }
        WechatEntity wechatEntity = new WechatEntity();
        return wechatEntity;
    }
}
