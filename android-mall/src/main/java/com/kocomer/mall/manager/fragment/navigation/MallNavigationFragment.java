package com.kocomer.mall.manager.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.mall.R;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by kocomer on 2017/9/13.
 */

public class MallNavigationFragment extends BaseFragment {
    private RelativeLayout navigationLayout;

    private ImageView imageView;

    @Override
    protected String setPageName() {
        return "MallNavigation";
    }

    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.mall_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.mall_selected);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navigationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_mall_navigation, null);
        imageView = (ImageView) navigationLayout.findViewById(R.id.fragment_mall_navigation_icon_iv);
        return navigationLayout;
    }


}