package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayScanWechatEntity;
import com.kocomer.pay.entity.PayWithdrawEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/21.
 */

public class PayWithdrawAnalysis implements Analysis<PayWithdrawEntity> {
    @Override
    public PayWithdrawEntity analysis(JSONObject jsonObject) throws JSONException {
        PayWithdrawEntity entity = new PayWithdrawEntity();
        entity.cny = jsonObject.getString("cny");
        return entity;
    }
}
