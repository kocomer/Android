package com.kocomer.android.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.kocomer.android.R;
import com.kocomer.core.activity.BaseActivity;

/**
 * Created by kocomer on 2017/8/26.
 */

public class ModulesActivity extends BaseActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("pppppppppppppppppppppppppppppp");
    }
}
