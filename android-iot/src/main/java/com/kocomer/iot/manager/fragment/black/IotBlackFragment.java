package com.kocomer.iot.manager.fragment.black;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.iot.R;
import com.kocomer.iot.analysis.BlackAnalysis;
import com.kocomer.iot.analysis.BlackRemoveAnalysis;
import com.kocomer.iot.entity.BlackEntity;
import com.kocomer.iot.entity.BlackRemoveEntity;
import com.kocomer.iot.entity.RouterEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/15.
 */

public class IotBlackFragment extends PageFragment<BlackEntity> implements View.OnClickListener {
    private ListView listView;

    @Override
    protected String setPageName() {
        return "IotBlack";
    }

    @Override
    public String getPageId() {
        return "IotBlack";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/iot_black.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new BlackAnalysis();
    }

    @Override
    public void onPageLoaded(final BlackEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.blackDetails.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.blackDetails[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder holder = null;
                if (convertView == null) {
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_iot_black_content_item, null);
                    holder = new ViewHolder();
                    holder.macTv = (TextView) convertView.findViewById(R.id.fragment_iot_black_content_item_mac_tv);
                    holder.dateTv = (TextView) convertView.findViewById(R.id.fragment_iot_black_content_item_date_tv);
                    holder.removeTv = (TextView) convertView.findViewById(R.id.fragment_iot_black_content_item_remove_tv);
                    convertView.setTag(holder);
                } else {
                    holder = (ViewHolder) convertView.getTag();
                }
                holder.macTv.setText(entity.blackDetails[position].cm);
                holder.dateTv.setText(entity.blackDetails[position].date);

                holder.removeTv.setTag(R.id.remove, entity.blackDetails[position].id);
                holder.removeTv.setOnClickListener(IotBlackFragment.this);
                return convertView;
            }
        });
    }

    class ViewHolder {
        TextView macTv;
        TextView dateTv;
        TextView removeTv;

    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof BlackRemoveEntity) {
            showMsg("移除成功");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_iot_black_content_item_remove_tv) {
            String idStr = (String) v.getTag(R.id.remove);
            HashMap<String, String> params = new HashMap<>();
            params.put("id", idStr);
            loadContent(Constants.STR_URL + "/iot_black.json", params, new BlackRemoveAnalysis());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_iot_black_content, null);
        listView = (ListView) view.findViewById(R.id.fragment_iot_black_content_lv);
        return view;
    }
}
