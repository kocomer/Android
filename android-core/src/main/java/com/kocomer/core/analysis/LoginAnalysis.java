package com.kocomer.core.analysis;

import com.android.volley.analysis.*;
import com.kocomer.core.entity.LoginEntity;
import com.kocomer.core.helper.Constants;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/27.
 */

public class LoginAnalysis implements com.android.volley.analysis.Analysis<LoginEntity> {
    @Override
    public LoginEntity analysis(JSONObject jsonObject) throws JSONException {
        LoginEntity entity = new LoginEntity();
        entity.userSession = jsonObject.getString(Constants.STR_USERSESSION);
        return entity;
    }
}
