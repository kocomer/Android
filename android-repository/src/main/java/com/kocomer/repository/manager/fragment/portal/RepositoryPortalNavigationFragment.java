package com.kocomer.repository.manager.fragment.portal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocomer.core.fragment.BaseFragment;

/**
 * 导航
 * Created by kocomer on 2017/7/23.
 */

public class RepositoryPortalNavigationFragment extends BaseFragment {
    @Override
    protected String setPageName() {
        return "RepositoryPortalNavigation";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
