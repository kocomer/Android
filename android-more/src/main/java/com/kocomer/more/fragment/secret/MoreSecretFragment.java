package com.kocomer.more.fragment.secret;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.more.R;
import com.kocomer.more.analysis.MoreSecretBindAnalysis;
import com.kocomer.more.entity.MoreSecretBindEntity;

/**
 * Created by kocomer on 2017/8/30.
 */

public class MoreSecretFragment extends BaseFragment {
    @Override
    protected String setPageName() {
        return "MoreSecret";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_secret_content, null);
        return view;
    }

}
