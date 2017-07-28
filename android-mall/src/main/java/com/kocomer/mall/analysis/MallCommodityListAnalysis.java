package com.kocomer.mall.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.mall.entity.MallCommodityListEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/23.
 */

public class MallCommodityListAnalysis implements Analysis<MallCommodityListEntity> {
    @Override
    public MallCommodityListEntity analysis(JSONObject jsonObject) throws JSONException {
        MallCommodityListEntity entity = new MallCommodityListEntity();
        return entity;
    }
}
