package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatEntity;
import com.kocomer.wechat.entity.WechatMemberEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/18.
 */

public class WechatMemberAnalysis implements Analysis<WechatMemberEntity> {
    @Override
    public WechatMemberEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatMemberEntity entity = new WechatMemberEntity();
        JSONObject memberJObj = jsonObject.getJSONObject("member");
        entity.header = memberJObj.optString("header");
        entity.point = memberJObj.optString("point");
        entity.balance = memberJObj.optString("balance");
        return entity;
    }
}
