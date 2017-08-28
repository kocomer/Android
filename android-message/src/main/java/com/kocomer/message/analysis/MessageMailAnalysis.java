package com.kocomer.message.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.message.entity.MessageMailEntity;
import com.kocomer.message.entity.MessageNoticeEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/27.
 */

public class MessageMailAnalysis implements Analysis<MessageMailEntity> {

    @Override
    public MessageMailEntity analysis(JSONObject jsonObject) throws JSONException {
        return null;
    }
}