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
     * 支付历史
     */
    String CELL_PAY_HISTORY = "pay_history";


    /**
     * 扫描会员卡
     */
    int REQUESTCODE_WECHAT = 3;
    /**
     * 扫描营销卡
     */
    int REQUESTCODE_ALIPAY = 4;
}
