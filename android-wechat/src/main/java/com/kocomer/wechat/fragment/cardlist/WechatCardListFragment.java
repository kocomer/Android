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
import com.kocomer.wechat.analysis.WechatCardListAnalysis;
import com.kocomer.wechat.analysis.WechatMemberListAnalysis;
import com.kocomer.wechat.entity.WechatCardListEntity;
import com.kocomer.wechat.entity.WechatMemberListEntity;
import com.kocomer.wechat.fragment.memberlist.WechatMemberListFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kocomer on 2017/7/31.
 */

public class WechatCardListFragment extends PageFragment<WechatCardListEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private ListView listView;
    private final List<WechatMemberListEntity> list = new ArrayList<WechatMemberListEntity>();
    private int page = 0;
    private int limit = 20;
    private ImageLoader imageLoader;

    @Override
    protected String setPageName() {
        return "WechatCardList";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_cardlist_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_wechat_cardlist_content_lv);
        imageLoader = new ImageLoader(queue, new ImageCache());

        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/wechat_cardList.json?firstResult=1&maxResults=20";
    }

    @Override
    public Analysis getAnalysis() {
        return new WechatCardListAnalysis();
    }

    @Override
    public void onPageLoaded(final WechatCardListEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.wechatCardEntityEntitys.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.wechatCardEntityEntitys[position];
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
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_wechat_cardlist_content_item, null);
                    viewHolder.brand = (TextView) convertView.findViewById(R.id.fragment_wechat_cardlist_content_item_brand_tv);
                    viewHolder.type = (TextView) convertView.findViewById(R.id.fragment_wechat_cardlist_content_item_type_tv);
                    viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_wechat_memberlist_content_item_remark_tv);
                    viewHolder.logo = (ImageView) convertView.findViewById(R.id.fragment_wechat_cardlist_content_item_head_iv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.brand.setText(entity.wechatCardEntityEntitys[position].brand);
                viewHolder.type.setText(entity.wechatCardEntityEntitys[position].type);
                viewHolder.remark.setText(entity.wechatCardEntityEntitys[position].remark);

                ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(viewHolder.logo, R.drawable.share_via_barcode, R.drawable.launcher_icon);
                imageLoader.get(entity.wechatCardEntityEntitys[position].logo, imageListener);

                return convertView;
            }
        });
    }

    class ViewHolder {
        public ImageView logo;
        public TextView brand;
        public TextView type;
        public TextView remark;
    }
}
