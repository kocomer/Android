package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatOperatorHistoryEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatOperatorHistoryAnalysis implements Analysis<WechatOperatorHistoryEntity> {
    @Override
    public WechatOperatorHistoryEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatOperatorHistoryEntity wechatOperatorHistoryEntity = new WechatOperatorHistoryEntity();

        return wechatOperatorHistoryEntity;
    }
}
