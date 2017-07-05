package com.kocomer.core.listener;

import com.android.volley.VolleyError;

/**
 * Created by kocomer on 2017/3/24.
 */

public interface PageListener<T> {

    void onPageLoaded(T entity);

    void onPageError(VolleyError error);

    void onPageBefore();

    void onPageAfter();
}
