package com.kocomer.corporation.fragment.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.corporation.R;
import com.kocomer.corporation.analysis.CorporationWalletHistoryAnalysis;
import com.kocomer.corporation.entity.CorporationWalletHistoryEntity;

/**
 * Created by kocomer on 2017/7/20.
 */

public class CorporationWalletHistoryFragment extends PageFragment<CorporationWalletHistoryEntity> {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_corporation_wallethistory_content, null);
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/corporation_walletHistory.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new CorporationWalletHistoryAnalysis();
    }

    @Override
    public void onPageLoaded(CorporationWalletHistoryEntity entity) {

    }
}
