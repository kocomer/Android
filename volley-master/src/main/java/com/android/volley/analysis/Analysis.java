package com.android.volley.analysis;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/23.
 */

public interface Analysis<T> {
    T analysis(JSONObject jsonObject) throws JSONException;
}
