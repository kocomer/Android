package com.kocomer.core.helper;

import android.app.Activity;
import android.app.Application;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kocomer on 2017/7/12.
 */

public class SesssionHelper {
    private static final String userSessionKey = "usk";
    private static final String userSessionFile = "usf";

    private static final String deviceSessionKey = "dsk";
    private static final String deviceSessionFile = "dsf";

    /**
     * 设置userSession
     *
     * @param activity
     * @param userSession
     */
    public static void setUserSession(Activity activity, String userSession) {
        SharedPreferences share = activity.getSharedPreferences(userSessionFile, MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit(); //编辑文件
        edit.putString(userSessionKey, userSession);
        edit.commit();  //保存数据信息
    }

    /**
     * 取得userSession
     *
     * @param activity
     * @return
     */
    public static String getUserSession(Activity activity) {
        System.out.println("activity = " + activity);
        SharedPreferences share = activity.getSharedPreferences(userSessionFile, MODE_PRIVATE);
        return share.getString(userSessionKey, "");
    }

    /**
     * 设置deviceSession
     *
     * @param activity
     * @param userSession
     */
    public static void setDeviceSession(Activity activity, String userSession) {
        SharedPreferences share = activity.getSharedPreferences(deviceSessionFile, MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit(); //编辑文件
        edit.putString(deviceSessionKey, userSession);
        edit.commit();  //保存数据信息
    }

    /**
     * 获取deviceSession
     *
     * @param activity
     * @return
     */
    public static String getDeviceSession(Activity activity) {
        SharedPreferences share = activity.getSharedPreferences(deviceSessionFile, MODE_PRIVATE);
        return share.getString(deviceSessionKey, "");
    }
}
