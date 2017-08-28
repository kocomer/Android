package com.kocomer.message.fragment.notice;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.message.R;
import com.kocomer.message.analysis.MessageNoticeAnalysis;
import com.kocomer.message.entity.MessageNoticeEntity;

/**
 * Created by kocomer on 2017/8/27.
 */

public class MessageNoticeFragment extends PageFragment<MessageNoticeEntity> implements View.OnClickListener {
    private ListView listView;

    @Override
    protected String setPageName() {
        return "MessageNotice";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message_notice_content, null);
        listView = (ListView) view.findViewById(R.id.fragment_message_notice_content_lv);
        return view;
    }

    @Override
    public String getPageId() {
        return "messageNotice";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/message_notice.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new MessageNoticeAnalysis();
    }

    @Override
    public void onPageLoaded(final MessageNoticeEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.messageNotices.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.messageNotices[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ViewHolder viewHolder = null;
                if (convertView == null) {
                    viewHolder = new ViewHolder();

                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_message_notice_content_item, null);
                    viewHolder.title = (TextView) convertView.findViewById(R.id.fragment_message_mail_notice_content_item_title_tv);
                    viewHolder.notice = (TextView) convertView.findViewById(R.id.fragment_message_mail_notice_content_item_notice_tv);
                    viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_message_mail_notice_content_item_date_tv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.title.setText(entity.messageNotices[position].title);
                viewHolder.date.setText(entity.messageNotices[position].date);
                viewHolder.notice.setText(entity.messageNotices[position].notice);
                return convertView;
            }

            class ViewHolder {
                public TextView title;
                public TextView date;
                public TextView notice;
            }
        });
    }
}
