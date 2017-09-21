package com.kocomer.repair.manager.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.repair.R;

/**
 * Created by kocomer on 2017/9/19.
 */

public class RepairNavigationFragment extends BaseFragment {
    private RelativeLayout navigationLayout;

    private ImageView imageView;

    @Override
    protected String setPageName() {
        return "WechatNavigation";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navigationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_repair_navigation, null);
        imageView = (ImageView) navigationLayout.findViewById(R.id.fragment_repair_navigation_icon_iv);
        return navigationLayout;
    }

    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.repair_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.repair_selected);
    }
}
