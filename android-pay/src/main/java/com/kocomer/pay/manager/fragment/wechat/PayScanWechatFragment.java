package com.kocomer.pay.manager.fragment.wechat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayScanWechatAnalysis;
import com.kocomer.pay.entity.PayScanWechatEntity;
import com.kocomer.pay.helper.PayConstants;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayScanWechatFragment extends ContentFragment implements View.OnClickListener {
    private AlertDialog.Builder confirmDialog;
    private LinearLayout layout;
    private Button scanBtn;
    private EditText moneyEt;

    @Override
    protected String setPageName() {
        return "PayScanWechat";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_scanwechat_content, null);
        moneyEt = (EditText) layout.findViewById(R.id.fragment_pay_scanwechat_content_money_et);
        layout.findViewById(R.id.fragment_pay_scanwechat_content_scan_btn).setOnClickListener(this);
        confirmDialog = new AlertDialog.Builder(getActivity());
        confirmDialog.setTitle("确认金额");
        return layout;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_pay_scanwechat_content_scan_btn) {
            String money = moneyEt.getText().toString();
            confirmDialog.setMessage("确认金额:" + money + "元");
            confirmDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), CaptureActivity.class);
                    intent.setAction(Intents.Scan.ACTION);
                    startActivityForResult(intent, PayConstants.REQUESTCODE_WECHATPAYBAR);
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
        if (requestCode == PayConstants.REQUESTCODE_WECHATPAYBAR) {
            HashMap<String, String> params = new HashMap<String, String>();
            params.put("price", moneyEt.getText().toString());
            params.put("authCode", result);
            loadContent(Constants.STR_URL + "/pay_scanwechat.json", params, new PayScanWechatAnalysis());
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayScanWechatEntity) {
            new AlertDialog.Builder(getActivity()).setMessage("支付成功").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    getActivity().finish();
                }
            }).create().show();
        }
    }
}
