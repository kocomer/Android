package com.kocomer.mall.manager;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.mall.R;
import com.kocomer.mall.helper.MallConstants;
import com.kocomer.mall.manager.activity.MallCommodityListActivity;
import com.kocomer.mall.manager.activity.MallDeliveryListActivity;
import com.kocomer.mall.manager.activity.MallOrderListActivity;

/**
 * Created by kocomer on 2017/9/9.
 */

public class MallFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Mall";
    }

    private LinearLayout layout;
    private LinearLayout contentLayout;

    private ModulesEntity.Module.Cell[] cells;

    public MallFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_mall, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_mall_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("code === " + cell.code);
            switch (cell.code) {
                case MallConstants.CELL_MALL_COMMODITYLIST: {//商品列表
                    inflater.inflate(R.layout.fragment_mall_commoditylist, contentLayout).findViewById(R.id.fragment_mall_commoditylist_ll).setOnClickListener(this);
                }
                break;
                case MallConstants.CELL_MALL_ORDERLIST: {//订单列表
                    inflater.inflate(R.layout.fragment_mall_orderlist, contentLayout).findViewById(R.id.fragment_mall_orderlist_ll).setOnClickListener(this);
                }
                break;
                case MallConstants.CELL_MALL_DELIVERYLIST: {//配送列表
                    inflater.inflate(R.layout.fragment_mall_deliverylist, contentLayout).findViewById(R.id.fragment_mall_deliverylist_ll).setOnClickListener(this);
                }
                break;
            }
        }
        return layout;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_mall_commoditylist_ll) {//
            startActivity(new Intent(getActivity(), MallCommodityListActivity.class));
        } else if (i == R.id.fragment_mall_orderlist_ll) {
            startActivity(new Intent(getActivity(), MallOrderListActivity.class));
        } else if (i == R.id.fragment_mall_deliverylist_ll) {
            startActivity(new Intent(getActivity(), MallDeliveryListActivity.class));
        }
    }
}