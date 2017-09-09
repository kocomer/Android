package com.kocomer.pay.fragment.list;

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
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayListAnalysis;
import com.kocomer.pay.analysis.PayListRefundAnalysis;
import com.kocomer.pay.entity.PayListEntity;
import com.kocomer.pay.entity.PayListRefundEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/8/17.
 */

public class PayListFragment extends PageFragment<PayListEntity> implements View.OnClickListener {
    private ListView listView;
    private AlertDialog.Builder confirmDialog;
    private LinearLayout layout;
    private Button scanBtn;
    private EditText moneyEt;
    private PayListEntity payListEntity;

    @Override
    protected String setPageName() {
        return "PayList";
    }

    @Override
    public String getPageId() {
        return "payList";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_list.json?firstResult=0&maxResults=20";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayListAnalysis();
    }

    @Override
    public void onPageLoaded(final PayListEntity entity) {
        this.payListEntity = entity;
        listView.setAdapter(new MyAdapter());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_list_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_pay_list_content_lv);
        return layout;
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayListEntity) {
            this.payListEntity = (PayListEntity) entity;
            listView.setAdapter(new MyAdapter());
        } else if (entity instanceof PayListRefundEntity) {
            PayListRefundEntity payListRefundEntity = (PayListRefundEntity) entity;
            showMsg("退款成功");
        }
    }

    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return payListEntity.payListItems.length;
        }

        @Override
        public Object getItem(int position) {
            return payListEntity.payListItems[position];
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
                convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_pay_list_content_item, null);
                viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_date_tv);
                viewHolder.money = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_money_tv);
                viewHolder.type = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_type_tv);
                viewHolder.source = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_source_tv);
                viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_remark_tv);
                viewHolder.status = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_status_tv);
                viewHolder.refund = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_refund_tv);
                viewHolder.refundBtn = (TextView) convertView.findViewById(R.id.fragment_pay_list_content_item_refundsubmit_tv);
                viewHolder.refundBtn.setTag(R.id.refund, position);
                viewHolder.refundBtn.setOnClickListener(PayListFragment.this);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.date.setText(payListEntity.payListItems[position].date);
            viewHolder.money.setText(payListEntity.payListItems[position].money);
            viewHolder.type.setText(payListEntity.payListItems[position].type);
            viewHolder.remark.setText(payListEntity.payListItems[position].remark);
            viewHolder.source.setText(payListEntity.payListItems[position].source);
            viewHolder.status.setText(payListEntity.payListItems[position].status);
            viewHolder.refund.setText(payListEntity.payListItems[position].refund);
            return convertView;
        }
    }

    class ViewHolder {
        public TextView id;
        public TextView date;
        public TextView money;
        public TextView type;
        public TextView remark;
        public TextView source;
        public TextView status;
        public TextView refund;
        public TextView refundBtn;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_pay_list_content_item_refundsubmit_tv) {
            int position = (int) v.getTag(R.id.refund);
            final PayListEntity.PayListItem payListItem = this.payListEntity.payListItems[position];

            final EditText passwordEt = new EditText(getActivity());
            new AlertDialog.Builder(getActivity()).setTitle("温馨提示").setView(passwordEt).setMessage("输入退款密码").setNegativeButton("取消", null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    HashMap<String, String> params = new HashMap<String, String>();
                    params.put("id", payListItem.id);
                    params.put("refund", payListItem.money);
                    params.put("password", passwordEt.getText().toString());
                    loadContent(Constants.STR_URL + "/pay_list.json", params, new PayListRefundAnalysis());
                }
            }).create().show();
        }
    }
}
