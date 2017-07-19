package com.kocomer.pay.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kocomer.pay.R;
import com.kocomer.core.fragment.BaseFragment;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayNavigationFragment extends BaseFragment {
    private RelativeLayout navagationLayout;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navagationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_pay_navigation, null);
        return navagationLayout;
    }


}