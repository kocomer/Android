package com.kocomer.corporation.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.corporation.entity.CorporationWalletAccountEntity;
import com.kocomer.corporation.entity.CorporationWalletHistoryEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWalletHistoryAnalysis implements Analysis<CorporationWalletHistoryEntity> {
    @Override
    public CorporationWalletHistoryEntity analysis(JSONObject jsonObject) throws JSONException {
        JSONArray historysJAry = jsonObject.getJSONArray("historys");
        CorporationWalletHistoryEntity entity = new CorporationWalletHistoryEntity();
        int length = historysJAry.length();
        entity.createCorporationWalletHistory(length);
        for (int i = 0; i < length; i++) {
            JSONObject historyJObj = historysJAry.getJSONObject(i);
            entity.corporationWalletHistories[i].date = historyJObj.optString("date");
            entity.corporationWalletHistories[i].remark = historyJObj.optString("remark");
            entity.corporationWalletHistories[i].money = historyJObj.optString("money");
            entity.corporationWalletHistories[i].desc = historyJObj.optString("desc");
            entity.corporationWalletHistories[i].extend = historyJObj.optString("extend");
        }
        return entity;
    }
}
