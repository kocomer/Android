package com.kocomer.core.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.entity.ModulesEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/3/25.
 */

public class ModulesAnalysis implements Analysis<ModulesEntity> {
    @Override
    public ModulesEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray moduleJAry = jsonObject.getJSONArray("modules");
        ModulesEntity entity = new ModulesEntity();
        int length = moduleJAry.length();
        entity.createModule(length);
        for (int i = 0; i < length; i++) {
            JSONObject mJObj = moduleJAry.getJSONObject(i);
            entity.module[i].code = mJObj.optString("code");
            entity.module[i].name = mJObj.optString("name");
            entity.module[i].text = mJObj.optString("text");
            JSONArray cellsJAry = mJObj.getJSONArray("cells");
            int cellLength = cellsJAry.length();
            entity.module[i].createCell(cellLength);
            for (int j = 0; j < cellLength; j++) {
                JSONObject cellJObj = cellsJAry.getJSONObject(j);
                entity.module[i].cells[j].name = cellJObj.getString("name");
                entity.module[i].cells[j].code = cellJObj.optString("code");
                entity.module[i].cells[j].text = cellJObj.optString("text");
            }
        }
        return entity;
    }
}
