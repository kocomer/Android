package com.kocomer.iot.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.iot.entity.RouterEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/9/12.
 */

public class RouterAnalysis implements Analysis<RouterEntity> {

    @Override
    public RouterEntity analysis(JSONObject jsonObject) throws JSONException {
        RouterEntity entity = new RouterEntity();
        JSONArray devicesJAry = jsonObject.getJSONArray("devices");
        int length = devicesJAry.length();
        entity.createRouter(length);
        for (int i = 0; i < length; i++) {
            JSONObject deviceJObj = devicesJAry.getJSONObject(i);
            entity.routers[i].id = deviceJObj.optString("id");
            entity.routers[i].serial = deviceJObj.optString("serial");
            entity.routers[i].name = deviceJObj.optString("name");
            entity.routers[i].online = deviceJObj.optBoolean("online");

           JSONArray clientsJAry = deviceJObj.optJSONArray("clients");
            if (clientsJAry != null) {
                int clientLength = clientsJAry.length();
                entity.routers[i].crateClient(clientLength);
                for (int j = 0; j < clientLength; j++){
                    JSONObject clientJObj= clientsJAry.getJSONObject(j);
                    entity.routers[i].clients[j].id = clientJObj.optString("id");
                    entity.routers[i].clients[j].date = clientJObj.optString("date");
                    entity.routers[i].clients[j].name = clientJObj.optString("cm");
                    entity.routers[i].clients[j].update = clientJObj.optString("update");
                }
            }
        }
        return entity;
    }
}
