package com.kocomer.wechat.entity;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatOperatorHistoryEntity {
    public WechatOperator[] wechatOperator;

    public void createWechatOperators(int length) {
        wechatOperator = new WechatOperator[length];
        for (int i = 0; i < length; i++) {
            wechatOperator[i] = new WechatOperator();
        }
    }

    public class WechatOperator {
        public String date;//变更时间
        public String operator;//操作人
        public String member;//变更人昵称
        public String content;//变更内容
    }
}
