package com.kocomer.message.entity;

/**
 * Created by kocomer on 2017/8/27.
 */

public class MessageNoticeEntity {
    public MessageNotice[] messageNotices;

    public void createMessageNotices(int length) {
        messageNotices = new MessageNotice[length];
        for (int i = 0; i < length; i++) {
            messageNotices[i] = new MessageNotice();
        }
    }

    public class MessageNotice {
        public String id;
        public String title;
        public String notice;
        public String date;

    }
}
