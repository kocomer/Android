package com.kocomer.pay.fragment.history;

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
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayHistoryAnalysis;
import com.kocomer.pay.entity.PayHistoryEntity;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayHistoryFragment extends PageFragment<PayHistoryEntity> {
    private ListView lv;
    private LinearLayout layout;

    @Override
    protected String setPageName() {
        return "PayHistory";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_history_content, null);
        lv = (ListView) layout.findViewById(R.id.fragment_pay_history_content_lv);
        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_history.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayHistoryAnalysis();
    }

    @Override
    public void onPageLoaded(final PayHistoryEntity entity) {
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.payHistories.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.payHistories[position];
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

                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_history_content_item, null);
                    viewHolder.paySource = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_paysource_tv);
                    viewHolder.money = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_money_tv);
                    viewHolder.desc = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_desc_tv);
                    viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_remark_tv);
                    viewHolder.extend = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_extend_tv);
                    viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_pay_history_content_item_date_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.paySource.setText(entity.payHistories[position].paySource);
                viewHolder.money.setText(entity.payHistories[position].money);
                viewHolder.desc.setText(entity.payHistories[position].desc);
                viewHolder.remark.setText(entity.payHistories[position].remark);
                viewHolder.extend.setText(entity.payHistories[position].extend);
                viewHolder.date.setText(entity.payHistories[position].date);
                return convertView;
            }
        });
    }

    class ViewHolder {
        public TextView paySource;
        public TextView money;
        public TextView desc;
        public TextView remark;
        public TextView extend;
        public TextView date;
    }
}
