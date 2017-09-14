package com.kocomer.pay.manager.fragment.withdrawsetting;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayWithdrawSettingAnalysis;
import com.kocomer.pay.entity.PayWithdrawSettingEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/3.
 */

public class PayWithdrawSettingFragment extends PageFragment<PayWithdrawSettingEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private TextView updateTv;
    private TextView withdrawTv;
    private CheckBox autoCb;
    private CheckBox manualCb;
    private CheckBox dayCb;
    private CheckBox weekCb;
    private TextView realNameTv;
    private TextView noTv;

    @Override
    protected String setPageName() {
        return "PayWithdraw";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_withdrawsetting_content, null);
        layout.findViewById(R.id.fragment_pay_withdrawsetting_update_tv).setOnClickListener(this);

        autoCb = (CheckBox) layout.findViewById(R.id.fragment_pay_withdrawsetting_content_auto_cb);
        autoCb.setOnClickListener(this);

        manualCb = (CheckBox) layout.findViewById(R.id.fragment_pay_withdrawsetting_content_manual_cb);
        manualCb.setOnClickListener(this);

        dayCb = (CheckBox) layout.findViewById(R.id.fragment_pay_withdrawsetting_content_day_cb);
        dayCb.setOnClickListener(this);

        weekCb = (CheckBox) layout.findViewById(R.id.fragment_pay_withdrawsetting_content_week_cb);
        weekCb.setOnClickListener(this);

        withdrawTv = (TextView) layout.findViewById(R.id.fragment_pay_withdrawsetting_withdraw_tv);
        realNameTv = (TextView) layout.findViewById(R.id.fragment_pay_withdrawsetting_realname_tv);
        noTv = (TextView) layout.findViewById(R.id.fragment_pay_withdrawsetting_no_tv);
        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_withdrawSetting.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayWithdrawSettingAnalysis();
    }

    @Override
    public void onPageLoaded(final PayWithdrawSettingEntity entity) {
        withdrawTv.setText(entity.withdraw);
        realNameTv.setText(entity.realName);
        noTv.setText(entity.no);
    }


    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayWithdrawSettingEntity) {
            PayWithdrawSettingEntity payWithdrawSettingEntity = (PayWithdrawSettingEntity) entity;
            withdrawTv.setText(payWithdrawSettingEntity.withdraw);
            showMsg("状态已更改");
        }
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        HashMap<String, String> params = new HashMap<>();
        if (id == R.id.fragment_pay_withdrawsetting_update_tv) {
            System.out.println(autoCb.getText() + " : " + manualCb.getText() + " : " + dayCb.getText() + " : " + weekCb.getText());
            System.out.println(autoCb.isChecked() + " : " + manualCb.isChecked() + " : " + dayCb.isChecked() + " : " + weekCb.isChecked());
            if (autoCb.isChecked()) {
                params.put("withdraw", "AUTO");
            } else if (manualCb.isChecked()) {
                params.put("withdraw", "MANUAL");
            } else if (dayCb.isChecked()) {
                params.put("withdraw", "DAY");
            } else if (weekCb.isChecked()) {
                params.put("withdraw", "WEEK");
            } else {
                showMsg("请选择");
                return;
            }

            loadContent(Constants.STR_URL + "/pay_withdrawSetting.json", params, new PayWithdrawSettingAnalysis());
        } else if (id == R.id.fragment_pay_withdrawsetting_content_auto_cb) {
            manualCb.setChecked(false);
            dayCb.setChecked(false);
            weekCb.setChecked(false);
            autoCb.setChecked(true);
        } else if (id == R.id.fragment_pay_withdrawsetting_content_manual_cb) {
            autoCb.setChecked(false);
            dayCb.setChecked(false);
            weekCb.setChecked(false);
            manualCb.setChecked(true);
        } else if (id == R.id.fragment_pay_withdrawsetting_content_day_cb) {
            autoCb.setChecked(false);
            manualCb.setChecked(false);
            weekCb.setChecked(false);
            dayCb.setChecked(true);
        } else if (id == R.id.fragment_pay_withdrawsetting_content_week_cb) {
            autoCb.setChecked(false);
            manualCb.setChecked(false);
            dayCb.setChecked(false);
            weekCb.setChecked(true);
        }
    }
}
