package com.kocomer.more.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.more.entity.MoreSecretBindEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/8/30.
 */

public class MoreSecretBindAnalysis implements Analysis<MoreSecretBindEntity> {
    @Override
    public MoreSecretBindEntity analysis(JSONObject jsonObject) throws JSONException {
        MoreSecretBindEntity moreSecretEntity = new MoreSecretBindEntity();
        if (jsonObject.optBoolean("bind")) {
            moreSecretEntity.bind = true;
        }
        return moreSecretEntity;
    }
}
