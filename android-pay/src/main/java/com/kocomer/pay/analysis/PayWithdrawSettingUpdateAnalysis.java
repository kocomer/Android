package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayWithdrawSettingUpdateEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/3.
 */

public class PayWithdrawSettingUpdateAnalysis implements Analysis<PayWithdrawSettingUpdateEntity> {
    @Override
    public PayWithdrawSettingUpdateEntity analysis(JSONObject jsonObject) throws JSONException {
        PayWithdrawSettingUpdateEntity entity = new PayWithdrawSettingUpdateEntity();
        return entity;
    }
}
