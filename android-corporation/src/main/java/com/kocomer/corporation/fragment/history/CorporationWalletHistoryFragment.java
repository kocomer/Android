package com.kocomer.corporation.fragment.history;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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
    private ListView lv;
    private LinearLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_corporation_wallethistory_content, null);
        lv = (ListView) layout.findViewById(R.id.fragment_corporation_wallethistory_content_lv);
        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/corporation_walletHistory.json?firstResult=0&maxResults=50";
    }

    @Override
    public Analysis getAnalysis() {
        return new CorporationWalletHistoryAnalysis();
    }

    @Override
    public void onPageLoaded(final CorporationWalletHistoryEntity entity) {
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.corporationWalletHistories.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.corporationWalletHistories[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();

                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_corporation_wallethistory_content_item, null);
                    viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_corporation_wallethistory_content_item_date_tv);
                    viewHolder.money = (TextView) convertView.findViewById(R.id.fragment_corporation_wallethistory_content_item_money_tv);
                    viewHolder.desc = (TextView) convertView.findViewById(R.id.fragment_corporation_wallethistory_content_item_desc_tv);
                    viewHolder.extend = (TextView) convertView.findViewById(R.id.fragment_corporation_wallethistory_content_item_extend_tv);
                    viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_corporation_wallethistory_content_item_remark_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.date.setText(entity.corporationWalletHistories[position].date);
                viewHolder.money.setText(entity.corporationWalletHistories[position].money);
                viewHolder.desc.setText(entity.corporationWalletHistories[position].desc);
                viewHolder.extend.setText(entity.corporationWalletHistories[position].extend);
                viewHolder.remark.setText(entity.corporationWalletHistories[position].remark);
                return convertView;
            }
        });
    }

    class ViewHolder {
        public TextView date;
        public TextView money;
        public TextView desc;
        public TextView extend;
        public TextView remark;
    }
}
