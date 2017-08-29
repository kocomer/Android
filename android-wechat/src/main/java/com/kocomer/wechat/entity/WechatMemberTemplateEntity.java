package com.kocomer.wechat.entity;

/**
 * Created by kocomer on 2017/8/29.
 */

public class WechatMemberTemplateEntity {
    public WechatMemberTemplate[] wechatMemberTemplates;

    public void crateWechatMemberTemplate(int length) {
        wechatMemberTemplates = new WechatMemberTemplate[length];
        for (int i = 0; i < length; i++) {
            wechatMemberTemplates[i] = new WechatMemberTemplate();
        }
    }

    public class WechatMemberTemplate {
        public String brand;
        public String notice;
        public String desc;
        public String prerogative;
        public String cardId;
        public String remark;
    }
}
