package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatCardTemplateEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/8.
 */

public class WechatCardTemplateAnalysis implements Analysis<WechatCardTemplateEntity> {
    @Override
    public WechatCardTemplateEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray cardListJAry = jsonObject.getJSONArray("rows");
        WechatCardTemplateEntity wechatCardListEntity = new WechatCardTemplateEntity();
        int length = cardListJAry.length();
        wechatCardListEntity.createWechatCard(length);
        for (int i = 0; i < length; i++) {
            JSONObject cardJObj = cardListJAry.getJSONObject(i);
            wechatCardListEntity.wechatCardEntityEntitys[i].logo = cardJObj.optString("logo");
            wechatCardListEntity.wechatCardEntityEntitys[i].type = cardJObj.optString("type");
            wechatCardListEntity.wechatCardEntityEntitys[i].brand = cardJObj.optString("brand");
            wechatCardListEntity.wechatCardEntityEntitys[i].cardId = cardJObj.optString("cardId");
            wechatCardListEntity.wechatCardEntityEntitys[i].remark = cardJObj.optString("remark");
        }
        return wechatCardListEntity;
    }
}
