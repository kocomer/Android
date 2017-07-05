package com.kocomer.wechat.fragment.navigation;

import android.annotation.SuppressLint;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.wechat.R;

/**
 * Created by kocomer on 2017/3/27.
 */

public class WechatNavigationFragment extends BaseFragment {
    private RelativeLayout navagationLayout;

    private View.OnClickListener listener;

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navagationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_wechat_navigation, null);
        navagationLayout.setOnClickListener(listener);
        return navagationLayout;
    }


}
