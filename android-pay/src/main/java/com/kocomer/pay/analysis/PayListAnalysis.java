package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayListEntity;
import com.kocomer.pay.entity.PayScanAlipayEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/17.
 */

public class PayListAnalysis implements Analysis<PayListEntity> {
    @Override
    public PayListEntity analysis(JSONObject jsonObject) throws JSONException {
        PayListEntity entity = new PayListEntity();
        entity.results = jsonObject.getLong("results");

        JSONArray rowsJAry = jsonObject.getJSONArray("rows");
        int length = rowsJAry.length();
        entity.createPayListItems(length);
        for (int i = 0; i < length; i++) {
            JSONObject payJObj = rowsJAry.getJSONObject(i);
            entity.payListItems[i].id = payJObj.getString("id");
            entity.payListItems[i].date = payJObj.getString("date");
            entity.payListItems[i].money = payJObj.getString("money");
            entity.payListItems[i].type = payJObj.getString("type");
            entity.payListItems[i].status = payJObj.getString("status");
            entity.payListItems[i].refund = payJObj.getString("refund");
            entity.payListItems[i].remark = payJObj.optString("remark");
            entity.payListItems[i].source = payJObj.optString("source");
        }

        return entity;
    }
}