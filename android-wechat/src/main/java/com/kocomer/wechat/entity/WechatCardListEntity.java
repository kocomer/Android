package com.kocomer.wechat.entity;

/**
 * 微信营销卡解析实体类
 * Created by kocomer on 2017/8/8.
 */

public class WechatCardListEntity {

    public WechatCardEntity[] wechatCardEntityEntitys;

    public void createWechatCard(int length) {
        wechatCardEntityEntitys = new WechatCardEntity[length];
        for (int i = 0; i < length; i++) {
            wechatCardEntityEntitys[i] = new WechatCardEntity();
        }
    }

    public class WechatCardEntity {
        public String type = "";
        public String logo = "";
        public String brand = "";
        public String remark = "";
    }
}
