package com.kocomer.wechat.helper;

/**
 * Created by kocomer on 2017/7/13.
 */

public interface WechatConstants {
    /**
     * 微信扫会员卡
     */
    String CELL_WECHAT_SCANMEMBER = "wechat_scanMember";
    /**
     * 扫描营销卡
     */
    String CELL_WECHAT_SCANCARD = "wechat_scanCard";
    /**
     * 微信会员
     */
    String CELL_WECHAT_MEMBERLIST = "wechat_memberList";
    /**
     * 微信操作历史
     */
    String CELL_WECHAT_OPERATORHISTORY = "wechat_operatorHistory";
    /**
     * 微信营销卡列表
     */
    String CELL_WECHAT_CARDTEMPLATE= "wechat_cardTemplate";
    String CELL_WECHAT_MEMBERTEMPLATE= "wechat_cardTemplate";
    /**
     * 扫描会员卡
     */
    int REQUESTCODE_MEMBERCARD = 1;
    /**
     * 扫描营销卡
     */
    int REQUESTCODE_CARD = 2;
}
