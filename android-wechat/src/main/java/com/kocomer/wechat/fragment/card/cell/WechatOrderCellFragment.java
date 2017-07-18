package com.kocomer.wechat.fragment.card.cell;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.VolleyError;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.listener.ContentListener;

/**
 * Created by kocomer on 2017/3/26.
 */

public class WechatOrderCellFragment extends ContentFragment implements ContentListener {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onContentLoaded(Object entity) {
        super.onContentLoaded(entity);
    }

    @Override
    public void onContentBefore() {
        super.onContentBefore();
    }

    @Override
    public void onContentAfter() {
        super.onContentAfter();
    }

    @Override
    public void onContentError(VolleyError error) {
        super.onContentError(error);
    }
}
