package com.kocomer.corporation.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.corporation.R;
import com.kocomer.corporation.fragment.account.CorporationWalletAccountFragment;

/**
 * Created by kocomer on 2017/7/19.
 */

public class CorporationWalletAccountActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corporation_walletaccount);
    }
}
