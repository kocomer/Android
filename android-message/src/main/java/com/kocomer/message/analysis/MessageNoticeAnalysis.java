package com.kocomer.message.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.message.entity.MessageNoticeEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/27.
 */

public class MessageNoticeAnalysis implements Analysis<MessageNoticeEntity> {

    @Override
    public MessageNoticeEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray noticesJAry = jsonObject.getJSONArray("notices");
        int length = noticesJAry.length();
        MessageNoticeEntity messageNoticeEntity = new MessageNoticeEntity();
        messageNoticeEntity.createMessageNotices(length);
        for (int i = 0; i < length; i++) {
            JSONObject noticeJObj = noticesJAry.getJSONObject(i);
            messageNoticeEntity.messageNotices[i].id = noticeJObj.getString("id");
            messageNoticeEntity.messageNotices[i].title = noticeJObj.getString("title");
            messageNoticeEntity.messageNotices[i].notice = noticeJObj.getString("notice");
            messageNoticeEntity.messageNotices[i].date = noticeJObj.getString("date");
        }
        return messageNoticeEntity;
    }
}