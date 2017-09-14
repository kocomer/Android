package com.kocomer.mall.manager.fragment.orderlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.mall.R;
import com.kocomer.mall.analysis.MallDeliveryListAnalysis;
import com.kocomer.mall.analysis.MallOrderListAnalysis;
import com.kocomer.mall.entity.MallDeliveryListEntity;
import com.kocomer.mall.entity.MallOrderListEntity;

/**
 * Created by kocomer on 2017/9/13.
 */

public class MallOrderListFragment  extends PageFragment<MallOrderListEntity> implements View.OnClickListener {
    private LinearLayout layout;

    @Override
    protected String setPageName() {
        return "MallOrderList";
    }

    @Override
    public String getPageId() {
        return "MallOrderList";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_list.json?firstResult=0&maxResults=20";
    }

    @Override
    public Analysis getAnalysis() {
        return new MallOrderListAnalysis();
    }

    @Override
    public void onPageLoaded(final MallOrderListEntity entity) {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_mall_deliverylist_content, null);
        return layout;
    }

    @Override
    public void onContentLoaded(Object entity) {

    }

}