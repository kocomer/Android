package com.kocomer.message.fragment.mail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.message.R;
import com.kocomer.message.analysis.MessageMailAnalysis;
import com.kocomer.message.entity.MessageMailEntity;

/**
 * 站内信
 * Created by kocomer on 2017/8/26.
 */

public class MessageMailFragment extends PageFragment<MessageMailEntity> implements View.OnClickListener {
    private ListView listView;

    @Override
    protected String setPageName() {
        return "MessageMail";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_mail_content, null);
        listView = (ListView) view.findViewById(R.id.fragment_message_mail_content_lv);
        return view;
    }

    @Override
    public String getPageId() {
        return "messageMail";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/message_mail.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new MessageMailAnalysis();
    }

    @Override
    public void onPageLoaded(MessageMailEntity entity) {

    }
}
