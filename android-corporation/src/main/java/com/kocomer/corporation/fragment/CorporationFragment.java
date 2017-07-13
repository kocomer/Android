package com.kocomer.corporation.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.entity.CellsEntity;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.corporation.R;
import com.kocomer.corporation.analysis.CorporationAnalysis;
import com.kocomer.corporation.entity.CorporationEntity;
import com.kocomer.corporation.helper.CorporationConstants;

/**
 * Created by kocomer on 2017/3/26.
 */

public class CorporationFragment extends ContentFragment {
    private LinearLayout linearLayout;
    private ModulesEntity.Module.Cell[] cells;

    public void setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_corporation, null);

        int length = cells.length;
        for (int i = 0; i < length; i++) {
            switch (cells[i].code) {
                case CorporationConstants.CELL_CORPORATION_WALLETACCOUNT: {
                    inflater.inflate(R.layout.fragment_corporation_walletaccount, linearLayout);
                }
                break;
            }
        }
        return linearLayout;
    }
}
