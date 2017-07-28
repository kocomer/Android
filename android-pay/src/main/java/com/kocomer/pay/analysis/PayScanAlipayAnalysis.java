package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayScanAlipayEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/24.
 */

public class PayScanAlipayAnalysis implements Analysis<PayScanAlipayEntity> {
    @Override
    public PayScanAlipayEntity analysis(JSONObject jsonObject) throws JSONException {
        PayScanAlipayEntity entity = new PayScanAlipayEntity();
        return entity;
    }
}
