package com.kocomer.message.fragment.navigation;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.message.R;
import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.message.analysis.MessageNoticeAnalysis;
import com.kocomer.message.entity.MessageNoticeEntity;
import com.kocomer.message.helper.MessageRepository;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by kocomer on 2017/8/26.
 */

public class MessageNavigationFragment extends ContentFragment {
    private RelativeLayout navigationLayout;

    @Override
    protected String setPageName() {
        return "MessageNavigation";
    }

    private ImageView imageView;

    private ImageView pointIv;

    private Thread thread = new Thread() {
        @Override
        public void run() {
            System.out.println("interrupted() = " + interrupted());
            while (!interrupted()) {
                System.out.println("======================");
                loadContent(Constants.STR_URL + "/message_notice.json", new MessageNoticeAnalysis());
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        thread.interrupt();
    }


    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.message_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.message_selected);
        pointIv.setVisibility(View.GONE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navigationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_message_navigation, null);
        imageView = (ImageView) navigationLayout.findViewById(R.id.fragment_message_navigation_icon_iv);
        pointIv = (ImageView) navigationLayout.findViewById(R.id.fragment_message_navigation_point_iv);
        return navigationLayout;
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof MessageNoticeEntity) {
            MessageNoticeEntity messageNoticeEntity = (MessageNoticeEntity) entity;
            HashSet<String> noticeList = new HashSet<>();
            Set<String> repositorySet = MessageRepository.getNoticeList(getActivity());
            for (int i = 0, length = messageNoticeEntity.messageNotices.length; i < length; i++) {
                noticeList.add(messageNoticeEntity.messageNotices[i].id);
                if (!repositorySet.contains(messageNoticeEntity.messageNotices[i].id)) {
                    pointIv.setVisibility(View.VISIBLE);
                }
            }
            MessageRepository.setNoticeList(getActivity(), noticeList);
        }
    }
}