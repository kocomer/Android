package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatScanCardConsumeEntity;
import com.kocomer.wechat.entity.WechatScanCardEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/9.
 */

public class WechatScanCardConsumeAnalysis implements Analysis<WechatScanCardConsumeEntity> {
    @Override
    public WechatScanCardConsumeEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatScanCardConsumeEntity wechatScanCardConsumeEntity = new WechatScanCardConsumeEntity();

        return wechatScanCardConsumeEntity;
    }
}
