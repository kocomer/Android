package com.kocomer.pay.manager.fragment.storelist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayStoreListAnalysis;
import com.kocomer.pay.entity.PayStoreListEntity;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreListFragment extends PageFragment<PayStoreListEntity> implements View.OnClickListener {
    private ListView listView;

    @Override
    protected String setPageName() {
        return "PayStoreList";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_storelist_content, null);
        listView = (ListView) view.findViewById(R.id.fragment_pay_storelist_content_lv);
        return view;
    }

    @Override
    public String getPageId() {
        return "PayStoreList";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_storeList.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayStoreListAnalysis();
    }

    @Override
    public void onPageLoaded(final PayStoreListEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_storelist_content_item, null);
                return convertView;
            }
        });
    }

}
