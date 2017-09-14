package com.kocomer.pay.manager.fragment.withdraw;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayWithdrawAnalysis;
import com.kocomer.pay.analysis.PayWithdrawSubmitAnalysis;
import com.kocomer.pay.entity.PayWithdrawEntity;
import com.kocomer.pay.entity.PayWithdrawSubmitEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/8/17.
 */

public class PayWithdrawFragment extends PageFragment<PayWithdrawEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private TextView cny;

    @Override
    protected String setPageName() {
        return "PayWithdraw";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_pay_withdraw_content, null);
        cny = (TextView) layout.findViewById(R.id.fragment_pay_withdraw_content_cny_tv);
        layout.findViewById(R.id.fragment_pay_withdraw_content_alipay_btn).setOnClickListener(this);
        layout.findViewById(R.id.fragment_pay_withdraw_content_wechat_btn).setOnClickListener(this);
        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/pay_withdraw.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new PayWithdrawAnalysis();
    }

    @Override
    public void onPageLoaded(final PayWithdrawEntity entity) {
        cny.setText(entity.cny);
    }


    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayWithdrawSubmitEntity) {
            showMsg("取现申请已经提交");
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        HashMap<String, String> params = new HashMap<>();
        params.put("money", cny.getText().toString());
        if (id == R.id.fragment_pay_withdraw_content_alipay_btn) {
            params.put("type", "alipay");
            loadContent(Constants.STR_URL + "/pay_withdraw.json", params, new PayWithdrawSubmitAnalysis());
        } else if (id == R.id.fragment_pay_withdraw_content_wechat_btn) {
            params.put("type", "wechat");
            loadContent(Constants.STR_URL + "/pay_withdraw.json", params, new PayWithdrawSubmitAnalysis());
        }
    }
}
