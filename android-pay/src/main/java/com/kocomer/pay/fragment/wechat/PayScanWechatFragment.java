package com.kocomer.pay.fragment.wechat;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayScanWechatFragment extends ContentFragment implements View.OnClickListener {
    private AlertDialog.Builder confirmDialog;
    private LinearLayout layout;
    private Button scanBtn;
    private EditText moneyEt;

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

                }
            }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            }).create().show();
        }
    }
}
