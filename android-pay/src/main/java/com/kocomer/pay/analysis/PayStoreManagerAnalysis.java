package com.kocomer.pay.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.pay.entity.PayStoreEntity;
import com.kocomer.pay.entity.PayStoreManagerEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/10/13.
 */

public class PayStoreManagerAnalysis implements Analysis<PayStoreManagerEntity> {
    @Override
    public PayStoreManagerEntity analysis(JSONObject jsonObject) throws JSONException {
        System.out.println("jsonObject = " + jsonObject);
        PayStoreManagerEntity entity = new PayStoreManagerEntity();

        JSONArray storesJAry = jsonObject.getJSONArray("stores");
        int storeLength = storesJAry.length();
        entity.createPayStore(storeLength);
        for (int i = 0; i < storeLength; i++) {
            JSONObject storeJObj = storesJAry.getJSONObject(i);
            entity.payStores[i].id = storeJObj.getLong("id");
            entity.payStores[i].name = storeJObj.getString("name");
        }

        JSONArray rolesJAry = jsonObject.getJSONArray("roles");
        int roleLength = rolesJAry.length();
        entity.createPayRole(roleLength);
        for (int i = 0; i < roleLength; i++) {
            JSONObject roleJObj = storesJAry.getJSONObject(i);
            entity.payRoles[i].id = roleJObj.getLong("id");
            entity.payRoles[i].name = roleJObj.getString("name");
        }
        return entity;
    }
}
