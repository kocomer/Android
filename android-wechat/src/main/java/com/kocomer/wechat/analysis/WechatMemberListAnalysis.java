package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatMemberListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatMemberListAnalysis implements Analysis<WechatMemberListEntity> {
    @Override
    public WechatMemberListEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray memberListJAry = jsonObject.getJSONArray("memberList");
        WechatMemberListEntity wechatMemberListEntity = new WechatMemberListEntity();
        int length = memberListJAry.length();
        wechatMemberListEntity.createWechatMember(length);
        for (int i = 0; i < length; i++) {
            JSONObject memberJObj = memberListJAry.getJSONObject(i);
            wechatMemberListEntity.wechatMemberEntitys[i].nick = memberJObj.optString("nick");
            wechatMemberListEntity.wechatMemberEntitys[i].date = memberJObj.optString("date");
            wechatMemberListEntity.wechatMemberEntitys[i].head = memberJObj.optString("head");
            wechatMemberListEntity.wechatMemberEntitys[i].points = memberJObj.optString("points");
            wechatMemberListEntity.wechatMemberEntitys[i].remark = memberJObj.optString("remark");
        }
        return wechatMemberListEntity;
    }
}
