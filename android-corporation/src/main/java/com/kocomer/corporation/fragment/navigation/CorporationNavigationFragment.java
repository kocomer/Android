package com.kocomer.corporation.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.corporation.R;

/**
 * 公司
 * Created by kocomer on 2017/3/27.
 */

public class CorporationNavigationFragment extends BaseFragment {
    private View.OnClickListener listener;
    private RelativeLayout navitaionLayout;

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navitaionLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_corporation_navigation, null);
        navitaionLayout.setOnClickListener(listener);
        return navitaionLayout;
    }


}
