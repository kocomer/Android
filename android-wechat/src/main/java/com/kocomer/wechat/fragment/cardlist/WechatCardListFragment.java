package com.kocomer.wechat.fragment.cardlist;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.android.volley.toolbox.ImageLoader;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageCache;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatMemberListAnalysis;
import com.kocomer.wechat.entity.WechatMemberListEntity;
import com.kocomer.wechat.fragment.memberlist.WechatMemberListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kocomer on 2017/7/31.
 */

public class WechatCardListFragment extends PageFragment<WechatMemberListEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private ListView listView;
    private final List<WechatMemberListEntity> list = new ArrayList<WechatMemberListEntity>();
    private int page = 0;
    private int limit = 20;
    private ImageLoader imageLoader;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_memberlist_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_wechat_memberlist_content_lv);
        imageLoader = new ImageLoader(queue, new ImageCache());

        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/wechat_memberList.json?firstResult=1&maxResults=20";
    }

    @Override
    public Analysis getAnalysis() {
        return new WechatMemberListAnalysis();
    }

    @Override
    public void onPageLoaded(final WechatMemberListEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.wechatMemberEntitys.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.wechatMemberEntitys[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
//                WechatMemberListFragment.ViewHolder viewHolder = null;
//                if (convertView == null) {
//                    viewHolder = new WechatMemberListFragment.ViewHolder();
//                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_wechat_memberlist_content_item, null);
//                    viewHolder.nick = (TextView) convertView.findViewById(R.id.fragment_wechat_memberlist_content_item_nick_tv);
//                    viewHolder.points = (TextView) convertView.findViewById(R.id.fragment_wechat_memberlist_content_item_points_tv);
//                    viewHolder.date = (TextView) convertView.findViewById(R.id.fragment_wechat_memberlist_content_item_date_tv);
//                    viewHolder.head = (ImageView) convertView.findViewById(R.id.fragment_wechat_memberlist_content_item_head_iv);
//                    convertView.setTag(viewHolder);
//                } else {
//                    viewHolder = (WechatMemberListFragment.ViewHolder) convertView.getTag();
//                }
//                System.out.println("point = " + entity.wechatMemberEntitys[position].points);
//                viewHolder.nick.setText(entity.wechatMemberEntitys[position].nick);
//                viewHolder.points.setText(entity.wechatMemberEntitys[position].points);
//                viewHolder.date.setText(entity.wechatMemberEntitys[position].date);
//
//                ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(viewHolder.head, R.drawable.share_via_barcode, R.drawable.launcher_icon);
//                imageLoader.get(entity.wechatMemberEntitys[position].head, imageListener);

                return convertView;
            }
        });
    }

    class ViewHolder {
        public TextView nick;
        public TextView points;
        public TextView date;
        public ImageView head;
    }
}
