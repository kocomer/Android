package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayStoreListEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreListAnalysis implements Analysis<PayStoreListEntity> {
    @Override
    public PayStoreListEntity analysis(JSONObject jsonObject) throws JSONException {
        PayStoreListEntity entity = new PayStoreListEntity();
        return entity;
    }
}
