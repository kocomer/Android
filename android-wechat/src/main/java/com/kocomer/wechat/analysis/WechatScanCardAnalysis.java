package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatScanCardEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/21.
 */

public class WechatScanCardAnalysis implements Analysis<WechatScanCardEntity> {
    @Override
    public WechatScanCardEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatScanCardEntity wechatScanCardEntity = new WechatScanCardEntity();

        return wechatScanCardEntity;
    }
}
