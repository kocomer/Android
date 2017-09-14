package com.kocomer.mall.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.mall.entity.MallCommodityListEntity;
import com.kocomer.mall.entity.MallOrderListEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/23.
 */

public class MallOrderListAnalysis implements Analysis<MallOrderListEntity> {
    @Override
    public MallOrderListEntity analysis(JSONObject jsonObject) throws JSONException {
        MallOrderListEntity entity = new MallOrderListEntity();
        return entity;
    }
}
