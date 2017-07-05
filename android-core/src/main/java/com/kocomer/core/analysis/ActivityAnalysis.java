package com.kocomer.core.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.entity.ActivityEntity;
import com.kocomer.core.helper.Constants;

import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/24.
 */

public class ActivityAnalysis implements Analysis<ActivityEntity> {

    @Override
    public ActivityEntity analysis(JSONObject jsonObject) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.deviceSession = jsonObject.optString(Constants.STR_DEVICESESSION);
        return activityEntity;
    }
}
