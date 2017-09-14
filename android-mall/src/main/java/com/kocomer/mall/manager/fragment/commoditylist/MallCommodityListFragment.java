package com.kocomer.mall.manager.fragment.commoditylist;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.mall.R;
import com.kocomer.mall.analysis.MallCommodityListAnalysis;
import com.kocomer.mall.entity.MallCommodityListEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/13.
 */

public class MallCommodityListFragment extends PageFragment<MallCommodityListEntity> implements View.OnClickListener {
    private LinearLayout layout;

    @Override
    protected String setPageName() {
        return "MallCommodityList";
    }

    @Override
    public String getPageId() {
        return "MallCommodityList";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_list.json?firstResult=0&maxResults=20";
    }

    @Override
    public Analysis getAnalysis() {
        return new MallCommodityListAnalysis();
    }

    @Override
    public void onPageLoaded(final MallCommodityListEntity entity) {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_mall_commoditylist_content, null);
        return layout;
    }

    @Override
    public void onContentLoaded(Object entity) {

    }

}