package com.kocomer.pay.manager.fragment.alipay;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayScanAlipayAnalysis;
import com.kocomer.pay.entity.PayScanAlipayEntity;
import com.kocomer.pay.helper.PayConstants;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayScanAlipayFragment extends ContentFragment implements View.OnClickListener {
    private AlertDialog.Builder confirmDialog;
    private LinearLayout layout;
    private EditText moneyEt;
    private String amount;

    @Override
    protected String setPageName() {
        return "PayScanAlipay";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_scanalipay_content, null);
        confirmDialog = new AlertDialog.Builder(getActivity());
        confirmDialog.setTitle("确认金额");
        layout.findViewById(R.id.fragment_pay_scanalipay_content_scan_btn).setOnClickListener(this);
        moneyEt = (EditText) layout.findViewById(R.id.fragment_pay_scanalipay_content_money_et);
        return layout;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_pay_scanalipay_content_scan_btn) {
            String money = moneyEt.getText().toString();

            confirmDialog.setMessage("确认金额:" + money + "元");
            confirmDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), CaptureActivity.class);
                    intent.setAction(Intents.Scan.ACTION);
                    startActivityForResult(intent, PayConstants.REQUESTCODE_ALIPAYBAR);
                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        String result = data.getStringExtra("result");
        if (requestCode == PayConstants.REQUESTCODE_ALIPAYBAR) {
            HashMap<String, String> params = new HashMap<String, String>();
            amount = moneyEt.getText().toString();
            params.put("amount", amount);
            params.put("authCode", result);
            loadContent(Constants.STR_URL + "/pay_scanalipay.json", params, new PayScanAlipayAnalysis());
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayScanAlipayEntity) {
            PayScanAlipayEntity payScanAlipayEntity = (PayScanAlipayEntity) entity;
            new AlertDialog.Builder(getActivity()).setMessage("支付成功").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().finish();
                }
            }).create().show();
        }
    }
}
