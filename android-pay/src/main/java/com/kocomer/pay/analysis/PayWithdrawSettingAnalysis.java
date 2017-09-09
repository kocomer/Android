package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayWithdrawSettingEntity;
import com.kocomer.pay.entity.PayWithdrawSubmitEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/3.
 */

public class PayWithdrawSettingAnalysis implements Analysis<PayWithdrawSettingEntity> {
    @Override
    public PayWithdrawSettingEntity analysis(JSONObject jsonObject) throws JSONException {
        PayWithdrawSettingEntity entity = new PayWithdrawSettingEntity();
        entity.withdraw = jsonObject.optString("withdraw");
        entity.realName = jsonObject.optString("realName");
        entity.no = jsonObject.optString("no");
        return entity;
    }
}