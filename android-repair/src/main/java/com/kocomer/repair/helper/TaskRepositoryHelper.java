package com.kocomer.repair.helper;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

/**
 * Created by kocomer on 2017/9/21.
 */

public class TaskRepositoryHelper {
    public static final String name = "taskFile";
    public static final String taskKey = "taskKey";
    public static final String dateKey = "dateKey";

    /**
     * 取任务同时判断是否是当天数据，如果隔天则直接返回空
     *
     * @param context
     * @return
     */
    public Set<String> getTask(Context context) {
        if (new SimpleDateFormat("yyyy-MM-dd").format(new Date()).equals(context.getSharedPreferences(name, Context.MODE_PRIVATE).getStringSet(dateKey, null))) {
            return context.getSharedPreferences(name, Context.MODE_PRIVATE).getStringSet(taskKey, null);
        } else {
            return null;
        }

    }

    /**
     * 存入任务同时存入当前日期时间戳
     *
     * @param context
     * @param task
     */
    public void setTask(Context context, Set<String> task) {
        context.getSharedPreferences(name, Context.MODE_PRIVATE).edit().putString(dateKey, new SimpleDateFormat("yyyy-MM-dd").format(new Date())).commit();
        context.getSharedPreferences(name, Context.MODE_PRIVATE).edit().putStringSet(taskKey, task).commit();
    }


}
