package com.kocomer.core.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.entity.CellsEntity;
import com.kocomer.core.entity.ModulesEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/28.
 */

public class CellsAnalysis implements Analysis<CellsEntity> {

    @Override
    public CellsEntity analysis(JSONObject jsonObject) throws JSONException {

        JSONArray cellJAry = jsonObject.getJSONArray("cells");
        CellsEntity entity = new CellsEntity();
        int length = cellJAry.length();
        entity.createCell(length);
        for (int i = 0; i < length; i++) {
            JSONObject mJObj = cellJAry.getJSONObject(i);
            entity.cell[i].code = mJObj.getString("code");
            entity.cell[i].name = mJObj.getString("name");
            entity.cell[i].text = mJObj.getString("text");
            entity.cell[i].url = mJObj.getString("url");
        }
        return entity;
    }
}
