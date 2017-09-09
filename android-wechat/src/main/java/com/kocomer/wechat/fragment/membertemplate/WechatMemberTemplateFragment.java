package com.kocomer.wechat.fragment.membertemplate;

import android.app.AlertDialog;
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
import com.kocomer.wechat.analysis.WechatCardTemplateAnalysis;
import com.kocomer.wechat.analysis.WechatMemberTemplateAnalysis;
import com.kocomer.wechat.entity.WechatCardTemplateEntity;
import com.kocomer.wechat.entity.WechatMemberListEntity;
import com.kocomer.wechat.entity.WechatMemberTemplateEntity;
import com.kocomer.wechat.fragment.cardtemplate.WechatCardTemplateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kocomer on 2017/8/29.
 */

public class WechatMemberTemplateFragment extends PageFragment<WechatMemberTemplateEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private ListView listView;
    private ImageLoader imageLoader;

    @Override
    protected String setPageName() {
        return "WechatMemberTemplate";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_membertemplate_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_wechat_membertemplate_content_lv);
        imageLoader = new ImageLoader(queue, new ImageCache());

        return layout;
    }

    @Override
    public String getPageId() {
        return "WechatMemberTemplate";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/wechat_memberTemplate.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new WechatMemberTemplateAnalysis();
    }


    @Override
    public void onPageLoaded(final WechatMemberTemplateEntity entity) {
        listView.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return entity.wechatMemberTemplates.length;
            }

            @Override
            public Object getItem(int position) {
                return entity.wechatMemberTemplates[position];
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
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_wechat_membertemplate_content_item, null);
                    viewHolder.brand = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_brand_tv);
                    viewHolder.desc = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_desc_tv);
                    viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_remark_tv);
                    viewHolder.notice = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_notice_tv);
                    viewHolder.prerogative = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_prerogative_tv);
                    viewHolder.qr = (TextView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_qr_tv);
                    viewHolder.logo = (ImageView) convertView.findViewById(R.id.fragment_wechat_membertemplate_content_item_logo_iv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.brand.setText(entity.wechatMemberTemplates[position].brand);
                viewHolder.desc.setText(entity.wechatMemberTemplates[position].desc);
                viewHolder.remark.setText(entity.wechatMemberTemplates[position].remark);
                viewHolder.notice.setText(entity.wechatMemberTemplates[position].notice);
                viewHolder.prerogative.setText(entity.wechatMemberTemplates[position].prerogative);
                viewHolder.qr.setOnClickListener(WechatMemberTemplateFragment.this);
                viewHolder.qr.setTag(R.id.qr, entity.wechatMemberTemplates[position].cardId);

                ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(viewHolder.logo, R.drawable.loading, R.drawable.error);
                imageLoader.get(entity.wechatMemberTemplates[position].logo, imageListener);

                return convertView;
            }
        });
    }

    class ViewHolder {
        public ImageView logo;
        public TextView brand;
        public TextView desc;
        public TextView notice;
        public TextView prerogative;
        public TextView remark;
        public TextView qr;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_wechat_membertemplate_content_item_qr_tv) {
            Object cardId = v.getTag(R.id.qr);

            ImageView imageView = new ImageView(getActivity());
            ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, R.drawable.unknown, R.drawable.error);
            imageLoader.get(Constants.STR_URL + "/memberQrBar.img?cardId=" + cardId + "&corporationCode=" + Constants.coropratincode + "&platformFinger=" + Constants.platformFinger + "&storeFinger=" + Constants.storeFinger, imageListener);

            new AlertDialog.Builder(getActivity()).setTitle("二维码").setView(imageView).create().show();

        }
    }


}
