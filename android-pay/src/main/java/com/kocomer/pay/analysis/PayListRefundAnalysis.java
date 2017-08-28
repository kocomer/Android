package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayListRefundEntity;
import com.kocomer.pay.entity.PayWithdrawSubmitEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/24.
 */

public class PayListRefundAnalysis  implements Analysis<PayListRefundEntity> {
    @Override
    public PayListRefundEntity analysis(JSONObject jsonObject) throws JSONException {
        PayListRefundEntity entity = new PayListRefundEntity();
        return entity;
    }
}