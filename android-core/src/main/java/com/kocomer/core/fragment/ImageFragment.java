package com.kocomer.core.fragment;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kocomer on 2017/7/18.
 */

public abstract class ImageFragment extends ContentFragment {
    protected RequestQueue queue;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(this.getActivity());
        queue.start();
    }

    protected void loadImage(){

    }
}
