package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayStoreEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/10/12.
 */

public class PayStoreAnalysis implements Analysis<PayStoreEntity> {

    @Override
    public PayStoreEntity analysis(JSONObject jsonObject) throws JSONException {
        PayStoreEntity entity = new PayStoreEntity();
        return entity;
    }
}
