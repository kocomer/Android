package com.kocomer.pay.manager.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.pay.R;
import com.kocomer.core.fragment.BaseFragment;

/**
 * Created by kocomer on 2017/7/19.
 */

public class PayNavigationFragment extends BaseFragment {
    private RelativeLayout navigationLayout;

    private ImageView imageView;

    @Override
    protected String setPageName() {
        return "PayNavigation";
    }

    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.pay_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.pay_selected);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navigationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_pay_navigation, null);
        imageView = (ImageView) navigationLayout.findViewById(R.id.fragment_wechat_navigation_icon_iv);
        return navigationLayout;
    }


}