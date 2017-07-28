package com.kocomer.core.helper;

import com.android.volley.analysis.Analysis;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/3/23.
 */

public interface Constants {
    //    String STR_URL = "http://192.168.31.108:8080";
    String STR_URL = "http://192.168.149.42:8080";
    //    String STR_URL = "http://mifi.ipush.cc";
//    String STR_URL = "http://192.168.43.20:8080";
    String STR_CORPORATIONCODE = "corporationCode";
    String STR_PLATFORMFINGER = "platformFinger";
    String STR_USERSESSION = "userSession";
    String STR_STOREFINGER = "storeFinger";
    String STR_DEVICESESSION = "deviceSession";

    String coropratincode = "92215859-94a2-4a83-9c3a-5de83d31d1b1";
    String platformFinger = "92215859-94a2-4a83-9c3a-5de83d31d1b1";
    String storeFinger = "c5eda6ec-0638-45b5-83fc-e49015e4d750";


    int RESULT_RELOGIN = -1;// 重新跳转登录页面
    int RESULT_SUCCESS = 0;// 成功
    int RESULT_WARNING = 1;// 警告
    int RESULT_REFRESH = 2;// 刷新当前页面
}
