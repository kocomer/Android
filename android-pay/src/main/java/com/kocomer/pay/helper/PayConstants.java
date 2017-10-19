package com.kocomer.pay.helper;

/**
 * Created by kocomer on 2017/7/19.
 */

public interface PayConstants {
    /**
     * 微信扫码支付
     */
    String CELL_PAY_SCANWECHAT = "pay_scanwechat";
    /**
     * 支付宝扫码支付
     */
    String CELL_PAY_SCANALIPAY = "pay_scanalipay";
    /**
     * 支付列表
     */
    String CELL_PAY_LIST = "pay_list";
    /**
     * 支付历史
     */
    String CELL_PAY_HISTORY = "pay_history";
    /**
     * 商户取现
     */
    String CELL_PAY_WITHDRAW = "pay_withdraw";
    /**
     * 取现设置
     */
    String CELL_PAY_WITHDRAWSETTING = "pay_withdrawSetting";
    /**
     * 创建商户
     */
    String CELL_PAY_STORE = "pay_store";
    /**
     * 商户列表
     */
    String CELL_PAY_STORELIST = "pay_storeList";
    /**
     * 商户管理员
     */
    String CELL_PAY_STOREMANAGER = "pay_storemanager";


    /**
     * 扫描会员卡
     */
    int REQUESTCODE_WECHAT = 3;
    /**
     * 扫描营销卡
     */
    int REQUESTCODE_ALIPAY = 4;
    /**
     * 扫描支付宝付款码
     */
    int REQUESTCODE_ALIPAYBAR = 5;
    /**
     * 扫描微信支付码
     */
    int REQUESTCODE_WECHATPAYBAR = 6;
}
