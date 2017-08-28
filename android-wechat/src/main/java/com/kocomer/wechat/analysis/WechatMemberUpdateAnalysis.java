package com.kocomer.wechat.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.wechat.entity.WechatMemberEntity;
import com.kocomer.wechat.entity.WechatMemberUpdateEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/19.
 */

public class WechatMemberUpdateAnalysis implements Analysis<WechatMemberUpdateEntity> {
    @Override
    public WechatMemberUpdateEntity analysis(JSONObject jsonObject) throws JSONException {
        WechatMemberUpdateEntity entity = new WechatMemberUpdateEntity();

        return entity;
    }
}