package com.kocomer.pay.manager.fragment.store;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "PayStore";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pay_store_content, null);
        return view;
    }
}
