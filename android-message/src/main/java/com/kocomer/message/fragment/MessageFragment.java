package com.kocomer.message.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.message.R;
import com.kocomer.message.activity.MessageMailActivity;
import com.kocomer.message.activity.MessageNoticeActivity;
import com.kocomer.message.entity.MessageNoticeEntity;
import com.kocomer.message.helper.MessageConstants;

/**
 * Created by kocomer on 2017/8/26.
 */

public class MessageFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Message";
    }

    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout scancardLinearLayout;

    private ModulesEntity.Module.Cell[] cells;

    public MessageFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_message, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_message_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("code === " + cell.code);
            switch (cell.code) {
                case MessageConstants.CELL_MESSAGE_MAIL: {//站内信
                    inflater.inflate(R.layout.fragment_message_mail, contentLayout).findViewById(R.id.fragment_message_mail_ll).setOnClickListener(this);
                }
                break;
                case MessageConstants.CELL_MESSAGE_NOTICE: {//站内信
                    inflater.inflate(R.layout.fragment_message_notice, contentLayout).findViewById(R.id.fragment_message_notice_ll).setOnClickListener(this);
                }
                break;

            }
        }
        return layout;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_message_mail_ll) {//
            Intent intent = new Intent(getActivity(), MessageMailActivity.class);
            startActivity(intent);
        } else if (i == R.id.fragment_message_notice_ll) {
            Intent intent = new Intent(getActivity(), MessageNoticeActivity.class);
            startActivity(intent);
        }
    }
}