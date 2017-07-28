package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayHistoryEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/21.
 */

public class PayHistoryAnalysis implements Analysis<PayHistoryEntity> {
    @Override
    public PayHistoryEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray historysJAry = jsonObject.getJSONArray("historys");
        PayHistoryEntity payHistoryEntity = new PayHistoryEntity();
        int length = historysJAry.length();
        payHistoryEntity.createPayHistory(length);
        for (int i = 0; i < length; i++) {
            JSONObject historyJObj = historysJAry.getJSONObject(i);
            payHistoryEntity.payHistories[i].payer = historyJObj.optString("payer");
            payHistoryEntity.payHistories[i].paySource = historyJObj.optString("paySource");
            payHistoryEntity.payHistories[i].money = historyJObj.optString("money");
            payHistoryEntity.payHistories[i].desc = historyJObj.optString("desc");
            payHistoryEntity.payHistories[i].remark = historyJObj.optString("remark");
            payHistoryEntity.payHistories[i].extend = historyJObj.optString("extend");
            payHistoryEntity.payHistories[i].date = historyJObj.optString("date");
        }
        return payHistoryEntity;
    }
}
