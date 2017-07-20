package com.kocomer.pay.fragment.alipay;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayScanAlipayFragment extends ContentFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pay_scanalipay_content, null);
    }
}
