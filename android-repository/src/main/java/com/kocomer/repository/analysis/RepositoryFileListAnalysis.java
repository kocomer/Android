package com.kocomer.repository.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.repository.entity.RepositoryFileListEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/23.
 */

public class RepositoryFileListAnalysis implements Analysis<RepositoryFileListEntity> {
    @Override
    public RepositoryFileListEntity analysis(JSONObject jsonObject) throws JSONException {
        RepositoryFileListEntity entity = new RepositoryFileListEntity();

        return entity;
    }
}
