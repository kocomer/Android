package com.kocomer.repair.manager.fragment.real;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.repair.R;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairRealFragment extends ContentFragment {

    @Override
    protected String setPageName() {
        return "RepairReal";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repair_real_content, null);
        return view;
    }
}
