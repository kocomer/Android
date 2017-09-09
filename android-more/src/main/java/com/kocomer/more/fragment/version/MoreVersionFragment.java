package com.kocomer.more.fragment.version;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.more.R;

/**
 * Created by kocomer on 2017/8/30.
 */

public class MoreVersionFragment extends BaseFragment {
    @Override
    protected String setPageName() {
        return "MoreVersion";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_version_content, null);

        TextView versionTv = (TextView) view.findViewById(R.id.fragment_more_version_content_version_tv);
        versionTv.setText(Constants.version);

        TextView contentTv = (TextView) view.findViewById(R.id.fragment_more_version_content_content_tv);
        contentTv.setText(Constants.content);

        return view;
    }
}
