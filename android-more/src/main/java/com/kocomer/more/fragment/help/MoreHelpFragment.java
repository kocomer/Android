package com.kocomer.more.fragment.help;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.more.R;

/**
 * Created by kocomer on 2017/8/28.
 */

public class MoreHelpFragment extends BaseFragment {
    @Override
    protected String setPageName() {
        return "SettingHelp";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_help_content, null);
        WebView webView = (WebView) view.findViewById(R.id.fragment_more_help_content_wv);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.baidu.com/");
        return view;
    }
}
