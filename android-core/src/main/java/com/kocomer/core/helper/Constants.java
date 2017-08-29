package com.kocomer.core.helper;

import com.android.volley.analysis.Analysis;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/3/23.
 */

public interface Constants {
    int version = 1;
    //        String STR_URL = "http://192.168.31.108:8080";
//        String STR_URL = "http://192.168.31.63:8080";
//    String STR_URL = "http://192.168.149.42:8080";
    String STR_URL = "https://pay.ipush.cc";
    //        String STR_URL = "http://mifi.ipush.cc";
//    String STR_URL = "http://192.168.43.20:8080";
    String STR_CORPORATIONCODE = "corporationCode";
    String STR_PLATFORMFINGER = "platformFinger";
    String STR_USERSESSION = "userSession";
    String STR_STOREFINGER = "storeFinger";
    String STR_DEVICESESSION = "deviceSession";

    //服务器配置
    String coropratincode = "33e553ab-203d-443e-9908-fc5c2ba4b8a1";
    String platformFinger = "8e67e011-218d-4799-936a-ecc720b58b79";
    String storeFinger = "76536d1d-1915-4324-b468-5e9d31d8079d";


//    String coropratincode = "33e553ab-203d-443e-9908-fc5c2ba4b8a1";
//    String platformFinger = "33e553ab-203d-443e-9908-fc5c2ba4b8a1";
//    String storeFinger = "f876e810-742f-4fc3-895c-94cd703e9931";

    //本地配置
//    String coropratincode = "ea4af2b6-67a3-438f-bd95-ef1dfbaf7d55";
//    String platformFinger = "ea4af2b6-67a3-438f-bd95-ef1dfbaf7d55";
//    String storeFinger = "41bff68a-38e0-4772-b474-b39119ef0e04";


    int RESULT_RELOGIN = -1;// 重新跳转登录页面
    int RESULT_SUCCESS = 0;// 成功
    int RESULT_WARNING = 1;// 警告
    int RESULT_REFRESH = 2;// 刷新当前页面
}
