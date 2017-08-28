package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayWithdrawEntity;
import com.kocomer.pay.entity.PayWithdrawSubmitEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/24.
 */

public class PayWithdrawSubmitAnalysis implements Analysis<PayWithdrawSubmitEntity> {
    @Override
    public PayWithdrawSubmitEntity analysis(JSONObject jsonObject) throws JSONException {
        PayWithdrawSubmitEntity entity = new PayWithdrawSubmitEntity();
        return entity;
    }
}