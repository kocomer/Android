package com.kocomer.wechat.fragment.operatorhistory;

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
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatOperatorHistoryAnalysis;
import com.kocomer.wechat.entity.WechatOperatorHistoryEntity;
import com.kocomer.wechat.fragment.memberlist.WechatMemberListFragment;

import java.util.List;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatOperatorHistoryFragment extends PageFragment<WechatOperatorHistoryEntity> {
    private LinearLayout layout;
    private ListView listView;

    @Override
    protected String setPageName() {
        return "WechatOperatorHistory";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_operatorhistory_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_wechat_operatorhistory_lv);
        return layout;
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
    public void onPageLoaded(final WechatOperatorHistoryEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.wechatOperator.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.wechatOperator[position];
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

                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_wechat_operatorhistory_content_item, null);
                    viewHolder.operator = (TextView) convertView.findViewById(R.id.fragment_wechat_operatorhistory_content_operator_tv);
                    viewHolder.member = (TextView) convertView.findViewById(R.id.fragment_wechat_operatorhistory_content_member_tv);
                    viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_wechat_operatorhistory_content_date_tv);
                    viewHolder.content = (TextView) convertView.findViewById(R.id.fragment_wechat_operatorhistory_content_content_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.operator.setText(entity.wechatOperator[position].operator);
                viewHolder.member.setText(entity.wechatOperator[position].member);
                viewHolder.date.setText(entity.wechatOperator[position].date);
                viewHolder.content.setText(entity.wechatOperator[position].content);
                return convertView;
            }
        });

    }

    class ViewHolder {
        public TextView operator;
        public TextView member;
        public TextView date;
        public TextView content;
    }
}
