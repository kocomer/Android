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
import com.kocomer.iot.analysis.RouterBlackAnalysis;
import com.kocomer.iot.entity.RouterBlackEntity;
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
                    convertView.setTag(groupViewHolder);
                } else {
                    groupViewHolder = (GroupViewHolder) convertView.getTag();
                }
                if (!entity.routers[groupPosition].online) {
                    groupViewHolder.statusIv.setImageResource(R.drawable.device_offline);
                }
                groupViewHolder.nameTv.setText(entity.routers[groupPosition].name);
                groupViewHolder.serialTv.setText(entity.routers[groupPosition].serial);


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
                    childViewHolder.blackTv = (TextView) convertView.findViewById(R.id.fragment_iot_router_content_children_black_tv);

                    childViewHolder.blackTv.setTag(R.id.black, entity.routers[groupPosition].clients[childPosition].name);
                    childViewHolder.blackTv.setOnClickListener(IotRouterFragment.this);

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
        ImageView statusIv;//状态
    }

    class ChildViewHolder {
        TextView nameTv;//名字
        TextView dateTv;//登录时间
        TextView updateTv;//更新时间
        TextView blackTv;//黑名单
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof RouterBlackEntity) {
            RouterBlackEntity routerBlackEntity = (RouterBlackEntity) entity;
            showMsg("增加成功");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_iot_router_content_children_black_tv) {//黑名单
            String clientMac = (String) v.getTag(R.id.black);
            HashMap<String, String> params = new HashMap<>();
            params.put("command", "black");
            params.put("params", clientMac);
            loadContent(Constants.STR_URL + "/iot_router.json", params, new RouterBlackAnalysis());
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
