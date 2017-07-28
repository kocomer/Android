package com.kocomer.wechat.entity;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatMemberListEntity {
    public WechatMemberEntity[] wechatMemberEntitys;

    public void createWechatMember(int length) {
        wechatMemberEntitys = new WechatMemberEntity[length];
        for (int i = 0; i < length; i++) {
            wechatMemberEntitys[i] = new WechatMemberEntity();
        }
    }

    public class WechatMemberEntity {
        public String nick;
        public String head;
        public String points;
        public String date;
        public String remark;
    }
}
