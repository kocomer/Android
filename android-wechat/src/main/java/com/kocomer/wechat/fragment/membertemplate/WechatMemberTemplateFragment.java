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

                return convertView;
            }
        });
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_wechat_cardtemplate_content_item_qr_tv) {
            Object cardId = v.getTag(R.id.qr);

            ImageView imageView = new ImageView(getActivity());
            ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(imageView, R.drawable.unknown, R.drawable.error);
            imageLoader.get(Constants.STR_URL + "/qrBar.img?cardId=" + cardId + "&corporationCode=" + Constants.coropratincode + "&platformFinger=" + Constants.platformFinger + "&storeFinger=" + Constants.storeFinger, imageListener);

            new AlertDialog.Builder(getActivity()).setTitle("二维码").setView(imageView).create().show();

        } else if (id == R.id.fragment_wechat_cardtemplate_content_item_send_tv) {
            Object cardId = v.getTag(R.id.send);
        }
    }

    class ViewHolder {
        public ImageView logo;
        public TextView brand;
        public TextView notice;
        public TextView desc;
        public TextView cardId;
        public TextView prerogative;
        public TextView remark;
    }
}
