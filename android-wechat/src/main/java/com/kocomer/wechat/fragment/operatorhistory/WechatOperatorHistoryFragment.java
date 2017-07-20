package com.kocomer.wechat.fragment.operatorhistory;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatOperatorHistoryAnalysis;
import com.kocomer.wechat.entity.WechatOperatorHistoryEntity;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatOperatorHistoryFragment extends PageFragment<WechatOperatorHistoryEntity> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wechat_operatorhistory_content, null);
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/wechat_operatorHistory.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new WechatOperatorHistoryAnalysis();
    }

    @Override
    public void onPageLoaded(WechatOperatorHistoryEntity entity) {

    }
}
