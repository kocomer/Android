package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayStoreListEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreListAnalysis implements Analysis<PayStoreListEntity> {
    @Override
    public PayStoreListEntity analysis(JSONObject jsonObject) throws JSONException {
        PayStoreListEntity entity = new PayStoreListEntity();
        JSONArray storesJAry = jsonObject.getJSONArray("stores");
        int length = storesJAry.length();
        entity.createPayStore(length);
        for (int i = 0; i < length; i++) {
            JSONObject storeJObj = storesJAry.getJSONObject(i);
            entity.payStores[i].id = storeJObj.getString("id");
            entity.payStores[i].name = storeJObj.getString("name");
            entity.payStores[i].status = storeJObj.getString("status");
        }
        return entity;
    }
}
