package com.kocomer.iot.manager.fragment.router;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.iot.R;
import com.kocomer.iot.analysis.RouterAnalysis;
import com.kocomer.iot.entity.RouterEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/12.
 */

public class IotRouterFragment extends PageFragment<RouterEntity> implements View.OnClickListener {
    private LinearLayout layout;

    private ExpandableListView expandableListView;

    @Override
    protected String setPageName() {
        return "PayWithdraw";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_iot_router_content, null);
        expandableListView = (ExpandableListView) layout.findViewById(R.id.fragment_iot_router_content_ev);
        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/iot_router.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new RouterAnalysis();
    }

    @Override
    public void onPageLoaded(final RouterEntity entity) {
        expandableListView.setAdapter(new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return entity.routers.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return entity.routers[groupPosition].clients.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return entity.routers[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return entity.routers[groupPosition].clients[childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                GroupViewHolder groupViewHolder = null;
                if (convertView == null) {
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_iot_router_content_group, null);
                    groupViewHolder = new GroupViewHolder();
                    groupViewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_group_name_tv);
                    groupViewHolder.statusIv = (ImageView) convertView.findViewById(R.id.fragment_iot_router_content_group_status_iv);
                    groupViewHolder.serialTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_group_serial_tv);
                    groupViewHolder.restartTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_group_restart_tv);
                    groupViewHolder.shutdownTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_group_shutdown_tv);
                    convertView.setTag(groupViewHolder);
                } else {
                    groupViewHolder = (GroupViewHolder) convertView.getTag();
                }
                groupViewHolder.nameTv.setText(entity.routers[groupPosition].name);
                groupViewHolder.serialTv.setText(entity.routers[groupPosition].serial);

                groupViewHolder.shutdownTv.setTag(R.id.shutdown, entity.routers[groupPosition].id);
                groupViewHolder.shutdownTv.setOnClickListener(IotRouterFragment.this);

                groupViewHolder.restartTv.setTag(R.id.restart, entity.routers[groupPosition].id);
                groupViewHolder.restartTv.setOnClickListener(IotRouterFragment.this);
                return convertView;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                ChildViewHolder childViewHolder = null;
                if (convertView == null) {
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_iot_router_content_children, null);
                    childViewHolder = new ChildViewHolder();
                    childViewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_children_name_tv);
                    childViewHolder.dateTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_children_date_tv);
                    childViewHolder.updateTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_children_update_tv);
                    childViewHolder.blackBtn = (Button) convertView.findViewById(R.id.fragment_iot_router_content_children_black_btn);

                    childViewHolder.blackBtn.setTag(R.id.black, entity.routers[groupPosition].clients[childPosition].id);
                    childViewHolder.blackBtn.setOnClickListener(IotRouterFragment.this);

                    convertView.setTag(childViewHolder);
                } else {
                    childViewHolder = (ChildViewHolder) convertView.getTag();
                }

                childViewHolder.nameTv.setText(entity.routers[groupPosition].clients[childPosition].name);
                childViewHolder.dateTv.setText(entity.routers[groupPosition].clients[childPosition].date);
                childViewHolder.updateTv.setText(entity.routers[groupPosition].clients[childPosition].update);
                return convertView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return false;
            }
        });
    }


    class GroupViewHolder {
        TextView nameTv;//名字
        TextView serialTv;//名字
        TextView shutdownTv;//关机
        TextView restartTv;//重启
        ImageView statusIv;//状态
    }

    class ChildViewHolder {
        TextView nameTv;//名字
        TextView dateTv;//登录时间
        TextView updateTv;//更新时间
        TextView blackTv;//黑名单
        Button blackBtn;
    }

    @Override
    public void onContentLoaded(Object entity) {

    }

    @Override
    public void onClick(View v) {
        System.out.println("000" + v);
        int id = v.getId();
        if (id == R.id.fragment_iot_router_content_group_shutdown_tv) {//关机
            String idStr = (String) v.getTag(R.id.shutdown);
            HashMap<String, String> params = new HashMap<>();
            params.put("money", idStr);

        } else if (id == R.id.fragment_iot_router_content_group_restart_tv) {//重启
            String idStr = (String) v.getTag(R.id.restart);
        } else if (id == R.id.fragment_iot_router_content_children_black_btn) {//黑名单
            String idStr = (String) v.getTag(R.id.black);
            System.out.println("====================--");
        }
//        HashMap<String, String> params = new HashMap<>();
//        params.put("money", cny.getText().toString());
//        if (id == R.id.fragment_pay_withdraw_content_alipay_btn) {
//            params.put("type", "alipay");
//            loadContent(Constants.STR_URL + "/pay_withdraw.json", params, new PayWithdrawSubmitAnalysis());
//        } else if (id == R.id.fragment_pay_withdraw_content_wechat_btn) {
//            params.put("type", "wechat");
//            loadContent(Constants.STR_URL + "/pay_withdraw.json", params, new PayWithdrawSubmitAnalysis());
//        }
    }

}
