package com.kocomer.corporation.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.corporation.entity.CorporationWalletAccountEntity;
import com.kocomer.corporation.entity.CorporationWalletHistoryEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWalletHistoryAnalysis implements Analysis<CorporationWalletHistoryEntity> {
    @Override
    public CorporationWalletHistoryEntity analysis(JSONObject jsonObject) throws JSONException {
        CorporationWalletHistoryEntity entity = new CorporationWalletHistoryEntity();
        return entity;
    }
}
