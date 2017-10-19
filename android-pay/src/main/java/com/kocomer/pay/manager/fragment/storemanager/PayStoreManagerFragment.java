package com.kocomer.pay.manager.fragment.storemanager;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.analysis.SuccessAnalysis;
import com.kocomer.core.entity.SuccessEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayStoreManagerAnalysis;
import com.kocomer.pay.entity.PayStoreManagerEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/10/13.
 */

public class PayStoreManagerFragment extends PageFragment<PayStoreManagerEntity> {
    private Spinner storeSp;
    private Spinner roleSp;
    private EditText loginNameEt;//登录名
    private EditText inviteEt;//邀请码
    private TextView submitTv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_storemanager_content, null);
        storeSp = (Spinner) view.findViewById(R.id.fragment_pay_storemanager_store_sp);
        roleSp = (Spinner) view.findViewById(R.id.fragment_pay_storemanager_role_sp);

        loginNameEt = (EditText) view.findViewById(R.id.fragment_pay_storemanager_loginname_et);
        inviteEt = (EditText) view.findViewById(R.id.fragment_pay_storemanager_invite_et);
        view.findViewById(R.id.fragment_pay_storemanager_submit_tv).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_pay_storemanager_submit_tv) {
            String loginName = loginNameEt.getText().toString();
            String invite = inviteEt.getText().toString();
            HashMap<String, String> params = new HashMap<>();
            params.put("storeId", storeSp.getSelectedItemId() + "");
            params.put("roleId", roleSp.getSelectedItemId() + "");
            params.put("loginName", loginName);
            params.put("invite", invite);
            loadContent(Constants.STR_URL + "/pay_storemanager.json", params, new SuccessAnalysis());
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof SuccessEntity) {
            showMsg("创建成功");
        }
    }

    @Override
    protected String setPageName() {
        return "PayStoreManager";
    }

    @Override
    public String getPageId() {
        return "PayStoreManager";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_storemanager.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayStoreManagerAnalysis();
    }

    @Override
    public void onPageLoaded(final PayStoreManagerEntity entity) {
        roleSp.setAdapter(new SpinnerAdapter() {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_storemanager_content_item, null);
                    viewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_pay_storemanager_item_name_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.nameTv.setText(entity.payRoles[position].name);
                return convertView;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return entity.payRoles.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.payRoles[position];
            }

            @Override
            public long getItemId(int position) {
                return entity.payRoles[position].id;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_storemanager_content_item, null);
                    viewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_pay_storemanager_item_name_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.nameTv.setText(entity.payRoles[position].name);
                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return position;
            }

            @Override
            public int getViewTypeCount() {
                return entity.payRoles.length;
            }

            @Override
            public boolean isEmpty() {
                return entity.payRoles.length == 0 ? true : false;
            }
        });

        storeSp.setAdapter(new SpinnerAdapter() {
            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_storemanager_content_item, null);
                    viewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_pay_storemanager_item_name_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.nameTv.setText(entity.payStores[position].name);
                return convertView;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return entity.payStores.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.payStores[position];
            }

            @Override
            public long getItemId(int position) {
                return entity.payStores[position].id;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_storemanager_content_item, null);
                    viewHolder.nameTv = (TextView) convertView.findViewById(R.id.fragment_pay_storemanager_item_name_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.nameTv.setText(entity.payStores[position].name);
                return convertView;
            }

            @Override
            public int getItemViewType(int position) {
                return position;
            }

            @Override
            public int getViewTypeCount() {
                return entity.payStores.length;
            }

            @Override
            public boolean isEmpty() {
                return entity.payRoles.length == 0 ? true : false;
            }
        });
    }

    class ViewHolder {
        public TextView nameTv;
    }
}
