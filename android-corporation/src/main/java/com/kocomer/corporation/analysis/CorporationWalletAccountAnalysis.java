package com.kocomer.corporation.analysis;

import com.android.volley.analysis.Analysis;
import com.kocomer.corporation.entity.CorporationEntity;
import com.kocomer.corporation.entity.CorporationWalletAccountEntity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 公司取现账户解析器
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWalletAccountAnalysis implements Analysis<CorporationWalletAccountEntity> {

    @Override
    public CorporationWalletAccountEntity analysis(JSONObject jsonObject) throws JSONException {
        CorporationWalletAccountEntity corporationWalletAccountEntity = new CorporationWalletAccountEntity();

        return corporationWalletAccountEntity;
    }
}
