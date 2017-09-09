package com.kocomer.wechat.fragment.cardtemplate;

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
import com.kocomer.wechat.entity.WechatCardTemplateEntity;
import com.kocomer.wechat.entity.WechatMemberListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kocomer on 2017/7/31.
 */

public class WechatCardTemplateFragment extends PageFragment<WechatCardTemplateEntity> implements View.OnClickListener {
    private LinearLayout layout;
    private ListView listView;
    private final List<WechatMemberListEntity> list = new ArrayList<WechatMemberListEntity>();
    private ImageLoader imageLoader;

    @Override
    protected String setPageName() {
        return "WechatCardTemplate";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_cardtemplate_content, null);
        listView = (ListView) layout.findViewById(R.id.fragment_wechat_cardtemplate_content_lv);
        imageLoader = new ImageLoader(queue, new ImageCache());

        return layout;
    }

    @Override
    public String getPageId() {
        return "";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/wechat_cardTemplate.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new WechatCardTemplateAnalysis();
    }


    @Override
    public void onPageLoaded(final WechatCardTemplateEntity entity) {
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
                    convertView = getActivity().getLayoutInflater().inflate(R.layout.fragment_wechat_cardtemplate_content_item, null);
                    viewHolder.brand = (TextView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_brand_tv);
                    viewHolder.type = (TextView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_type_tv);
                    viewHolder.remark = (TextView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_remark_tv);
                    viewHolder.qr = (TextView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_qr_tv);
                    viewHolder.send = (TextView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_send_tv);
                    viewHolder.logo = (ImageView) convertView.findViewById(R.id.fragment_wechat_cardtemplate_content_item_head_iv);
                    convertView.setTag(viewHolder);
                } else {
                    viewHolder = (ViewHolder) convertView.getTag();
                }
                viewHolder.brand.setText(entity.wechatCardEntityEntitys[position].brand);
                viewHolder.type.setText(entity.wechatCardEntityEntitys[position].type);
                viewHolder.remark.setText(entity.wechatCardEntityEntitys[position].remark);
                viewHolder.qr.setOnClickListener(WechatCardTemplateFragment.this);
                viewHolder.qr.setTag(R.id.qr, entity.wechatCardEntityEntitys[position].cardId);
                viewHolder.send.setOnClickListener(WechatCardTemplateFragment.this);
                viewHolder.send.setTag(R.id.send, entity.wechatCardEntityEntitys[position].cardId);

                ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(viewHolder.logo, R.drawable.unknown, R.drawable.error);
                imageLoader.get(entity.wechatCardEntityEntitys[position].logo, imageListener);

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
            imageLoader.get(Constants.STR_URL + "/cardQrBar.img?cardId=" + cardId + "&corporationCode=" + Constants.coropratincode + "&platformFinger=" + Constants.platformFinger + "&storeFinger=" + Constants.storeFinger, imageListener);

            new AlertDialog.Builder(getActivity()).setTitle("二维码").setView(imageView).create().show();

        } else if (id == R.id.fragment_wechat_cardtemplate_content_item_send_tv) {
            Object cardId = v.getTag(R.id.send);
        }
    }

    class ViewHolder {
        public ImageView logo;
        public TextView brand;
        public TextView qr;
        public TextView send;
        public TextView type;
        public TextView remark;
    }
}
