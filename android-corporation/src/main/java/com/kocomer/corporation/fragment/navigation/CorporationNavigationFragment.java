package com.kocomer.corporation.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.corporation.R;

/**
 * 公司
 * Created by kocomer on 2017/3/27.
 */

public class CorporationNavigationFragment extends BaseFragment {
    private RelativeLayout navitaionLayout;
    private ImageView imageView;

    @Override
    protected String setPageName() {
        return "CorporationNavigation";
    }

    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.corporation_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.corporation_selected);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navitaionLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_corporation_navigation, null);
        imageView = (ImageView) navitaionLayout.findViewById(R.id.fragment_corporation_nav_icon_iv);
        return navitaionLayout;
    }


}
