package com.kocomer.corporation.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.corporation.R;
import com.kocomer.corporation.activity.CorporationWalletAccountActivity;
import com.kocomer.corporation.activity.CorporationWalletHistoryActivity;
import com.kocomer.corporation.activity.CorporationWithdrawActivity;
import com.kocomer.corporation.helper.CorporationConstants;

/**
 * Created by kocomer on 2017/3/26.
 */

public class CorporationFragment extends ContentFragment implements View.OnClickListener {
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
                    inflater.inflate(R.layout.fragment_corporation_walletaccount, linearLayout).findViewById(R.id.fragment_pay_walletaccount_ll).setOnClickListener(this);
                }
                break;
                case CorporationConstants.CELL_CORPORATION_WITHDRAW: {
                    inflater.inflate(R.layout.fragment_corporation_withdraw, linearLayout).findViewById(R.id.fragment_pay_walletwithdraw_ll).setOnClickListener(this);
                }
                break;
                case CorporationConstants.CELL_CORPORATION_WALLETHISTORY: {
                    inflater.inflate(R.layout.fragment_corporation_wallethistory, linearLayout).findViewById(R.id.fragment_pay_wallethistory_ll).setOnClickListener(this);
                }
                break;
            }
        }
        return linearLayout;
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_pay_walletaccount_ll) {
            startActivity(new Intent(getActivity(), CorporationWalletAccountActivity.class));
        } else if (i == R.id.fragment_pay_walletwithdraw_ll) {
            startActivity(new Intent(getActivity(), CorporationWithdrawActivity.class));
        } else if (i == R.id.fragment_pay_wallethistory_ll) {
            startActivity(new Intent(getActivity(), CorporationWalletHistoryActivity.class));

        }
    }
}
