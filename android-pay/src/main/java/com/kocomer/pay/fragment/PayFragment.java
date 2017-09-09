package com.kocomer.pay.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import com.kocomer.pay.R;
import com.kocomer.pay.activity.PayHistoryActivity;
import com.kocomer.pay.activity.PayListActivity;
import com.kocomer.pay.activity.PayScanAlipayActivity;
import com.kocomer.pay.activity.PayScanWechatActivity;
import com.kocomer.pay.activity.PayWithdrawActivity;
import com.kocomer.pay.activity.PayWithdrawSettingActivity;
import com.kocomer.pay.helper.PayConstants;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayFragment extends ContentFragment implements View.OnClickListener {

    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout scancardLinearLayout;

    @Override
    protected String setPageName() {
        return "Pay";
    }

    private ModulesEntity.Module.Cell[] cells;

    public PayFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_pay_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("code === " + cell.code);
            switch (cell.code) {
                case PayConstants.CELL_PAY_SCANWECHAT: {//微信扫会员卡
                    inflater.inflate(R.layout.fragment_pay_scanwechat, contentLayout).findViewById(R.id.fragment_pay_scanwechat_ll).setOnClickListener(this);
                }
                break;
                case PayConstants.CELL_PAY_SCANALIPAY: {
                    inflater.inflate(R.layout.fragment_pay_scanalipay, contentLayout).findViewById(R.id.fragment_pay_scanalipay_ll).setOnClickListener(this);
                }
                break;
                case PayConstants.CELL_PAY_LIST: {
                    inflater.inflate(R.layout.fragment_pay_list, contentLayout).findViewById(R.id.fragment_pay_list_ll).setOnClickListener(this);
                }
                break;
                case PayConstants.CELL_PAY_HISTORY: {
                    inflater.inflate(R.layout.fragment_pay_history, contentLayout).findViewById(R.id.fragment_pay_history_ll).setOnClickListener(this);
                }
                break;
                case PayConstants.CELL_PAY_WITHDRAW: {
                    inflater.inflate(R.layout.fragment_pay_withdraw, contentLayout).findViewById(R.id.fragment_pay_withdraw_ll).setOnClickListener(this);
                }
                break;
                case PayConstants.CELL_PAY_WITHDRAWSETTING: {
                    inflater.inflate(R.layout.fragment_pay_withdrawsetting, contentLayout).findViewById(R.id.fragment_pay_withdrawsetting_ll).setOnClickListener(this);
                }
                break;

            }
        }
        return layout;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //这里已经获取到了摄像头的权限，想干嘛干嘛了可以
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), CaptureActivity.class);
                    intent.setAction(Intents.Scan.ACTION);
                    startActivityForResult(intent, PayConstants.REQUESTCODE_ALIPAY);
                } else {
                    //这里是拒绝给APP摄像头权限，给个提示什么的说明一下都可以。
                    Toast.makeText(getActivity(), "请手动打开相机权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case PayConstants.REQUESTCODE_ALIPAY: {
                String result = data.getStringExtra("result");
                System.out.println("result = " + result);

                if (result != null && !"".equals(result)) {
//                    Intent intent = new Intent(getActivity(), WechatScanMemberActivity.class);
//                    intent.putExtra("code", result);
//                    startActivity(intent);
                }
            }
            break;
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_pay_scanwechat_ll) {//
            startActivity(new Intent(getActivity(), PayScanWechatActivity.class));
        } else if (i == R.id.fragment_pay_scanalipay_ll) {
            startActivity(new Intent(getActivity(), PayScanAlipayActivity.class));
        } else if (i == R.id.fragment_pay_history_ll) {
            startActivity(new Intent(getActivity(), PayHistoryActivity.class));
        } else if (i == R.id.fragment_pay_list_ll) {
            startActivity(new Intent(getActivity(), PayListActivity.class));
        } else if (i == R.id.fragment_pay_withdraw_ll) {
            startActivity(new Intent(getActivity(), PayWithdrawActivity.class));
        } else if (i == R.id.fragment_pay_withdrawsetting_ll) {
            startActivity(new Intent(getActivity(), PayWithdrawSettingActivity.class));
        }
    }
}
