package com.kocomer.mall.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.mall.entity.MallDeliveryListEntity;
import com.kocomer.mall.entity.MallOrderListEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/23.
 */

public class MallDeliveryListAnalysis implements Analysis<MallDeliveryListEntity> {
    @Override
    public MallDeliveryListEntity analysis(JSONObject jsonObject) throws JSONException {
        MallDeliveryListEntity entity = new MallDeliveryListEntity();
        return entity;
    }
}
