package com.kocomer.core.net;


import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Map;

/**
 * Created by kocomer on 2017/3/22.
 */

class CoreContentNet<T> extends Thread {
    private RequestQueue queue;

    public CoreContentNet(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public void getPageContent() {
        StringRequest request = new StringRequest("", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return super.getParams();
            }
        };
        queue.add(request);
    }

    enum CACHESTRATEGY {
        none, memery, sdcard
    }
}
