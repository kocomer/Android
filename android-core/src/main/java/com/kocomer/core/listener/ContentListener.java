package com.kocomer.core.listener;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;

/**
 * Created by kocomer on 2017/3/23.
 */

public interface ContentListener {
    void onContentLoaded(Object entity);

    void onContentError(VolleyError error);

    void onContentBefore();

    void onContentAfter();
}
