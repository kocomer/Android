package com.kocomer.message.helper;

import android.app.Activity;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kocomer on 2017/7/12.
 */

public class MessageRepository {
    //公告列表
    private static final String NOTICELISTFILE = "nlf";
    //公告列表key
    private static final String NOTICELISTFILEKEY = "nlk";

    public static void setNoticeList(Activity activity, Set<String> noticeSet) {
        SharedPreferences share = activity.getSharedPreferences(NOTICELISTFILE, MODE_PRIVATE);
        SharedPreferences.Editor edit = share.edit(); //编辑文件
        edit.putStringSet(NOTICELISTFILEKEY, noticeSet);
        edit.commit();  //保存数据信息
    }

    /**
     * 取得userSession
     *
     * @param activity
     * @return
     */
    public static Set<String> getNoticeList(Activity activity) {
        return activity.getSharedPreferences(NOTICELISTFILE, MODE_PRIVATE).getStringSet(NOTICELISTFILEKEY, new HashSet<String>());
    }

}
