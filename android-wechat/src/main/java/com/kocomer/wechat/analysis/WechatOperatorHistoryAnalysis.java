package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatOperatorHistoryEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatOperatorHistoryAnalysis implements Analysis<WechatOperatorHistoryEntity> {
    @Override
    public WechatOperatorHistoryEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray operatorsJAry = jsonObject.getJSONArray("operators");
        WechatOperatorHistoryEntity wechatOperatorHistoryEntity = new WechatOperatorHistoryEntity();
        int length = operatorsJAry.length();
        wechatOperatorHistoryEntity.createWechatOperators(length);
        for (int i = 0; i < length; i++) {
            JSONObject operatorJObj = operatorsJAry.getJSONObject(i);
            wechatOperatorHistoryEntity.wechatOperator[i].date = operatorJObj.optString("date");
            wechatOperatorHistoryEntity.wechatOperator[i].member = operatorJObj.optString("member");
            wechatOperatorHistoryEntity.wechatOperator[i].operator = operatorJObj.optString("operator");
            wechatOperatorHistoryEntity.wechatOperator[i].content = operatorJObj.optString("content");
        }
        return wechatOperatorHistoryEntity;
    }
}
