package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatMemberTemplateEntity;
import com.kocomer.wechat.entity.WechatMemberUpdateEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/29.
 */

public class WechatMemberTemplateAnalysis implements Analysis<WechatMemberTemplateEntity> {
    @Override
    public WechatMemberTemplateEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatMemberTemplateEntity entity = new WechatMemberTemplateEntity();
        JSONArray memberTemplateJAry = jsonObject.getJSONArray("memberTemplate");
        int length = memberTemplateJAry.length();
        entity.crateWechatMemberTemplate(length);
        for (int i = 0; i < length; i++) {
            JSONObject memberJObj = memberTemplateJAry.getJSONObject(i);
            entity.wechatMemberTemplates[i].logo = memberJObj.optString("logo");
            entity.wechatMemberTemplates[i].brand = memberJObj.optString("brand");
            entity.wechatMemberTemplates[i].cardId = memberJObj.optString("cardId");
            entity.wechatMemberTemplates[i].desc = memberJObj.optString("desc");
            entity.wechatMemberTemplates[i].notice = memberJObj.optString("notice");
            entity.wechatMemberTemplates[i].prerogative = memberJObj.optString("prerogative");
            entity.wechatMemberTemplates[i].remark = memberJObj.optString("remark");
        }
        return entity;
    }
}