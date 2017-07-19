package com.kocomer.android.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocomer.android.R;
import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.core.fragment.ContentFragment;

/**
 * Created by kocomer on 2017/7/19.
 */

public class WelcomeFragment extends ContentFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, null);
    }
}
