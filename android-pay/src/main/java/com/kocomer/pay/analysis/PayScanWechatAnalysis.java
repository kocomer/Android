package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayScanWechatEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/24.
 */

public class PayScanWechatAnalysis implements Analysis<PayScanWechatEntity> {
    @Override
    public PayScanWechatEntity analysis(JSONObject jsonObject) throws JSONException {
        PayScanWechatEntity entity = new PayScanWechatEntity();
        return entity;
    }
}
