package com.kocomer.wechat.fragment.scancard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatScanCardAnalysis;
import com.kocomer.wechat.analysis.WechatScanCardConsumeAnalysis;
import com.kocomer.wechat.entity.WechatScanCardConsumeEntity;
import com.kocomer.wechat.entity.WechatScanCardEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/7/18.
 */

public class WechatScanCardFragment extends ContentFragment implements View.OnClickListener {
    public String code;//会员编码
    private LinearLayout contentLayout;
    private TextView typeTv;
    private TextView titleTv;
    private TextView subTitleTv;
    private Button submitBtn;

    @Override
    protected String setPageName() {
        return "WechatScanCard";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_scancard_content, null);
        typeTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scancard_content_type_btn);
        titleTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scancard_content_title_btn);
        subTitleTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scancard_content_subtitle_btn);
        submitBtn = (Button) contentLayout.findViewById(R.id.fragment_wechat_scancard_content_submit_btn);
        submitBtn.setOnClickListener(this);
        loadContent(Request.Method.GET, Constants.STR_URL + "/wechat_scanCard.json?cardCode=" + code, null, new WechatScanCardAnalysis());
        return contentLayout;
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof WechatScanCardConsumeEntity) {
            WechatScanCardConsumeEntity wechatScanCardConsumeEntity = (WechatScanCardConsumeEntity) entity;
            showMsg("核销成功");
        } else if (entity instanceof WechatScanCardEntity) {
            WechatScanCardEntity wechatScanCardEntity = (WechatScanCardEntity) entity;
            typeTv.setText(wechatScanCardEntity.type);
            titleTv.setText(wechatScanCardEntity.title);
            subTitleTv.setText(wechatScanCardEntity.subTitle);
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_wechat_scancard_content_submit_btn) {

            HashMap<String, String> params = new HashMap<>();
            params.put("cardCode", code);
            params.put("status", "consume");
            loadContent(Constants.STR_URL + "/wechat_scanCard.json", params, new WechatScanCardConsumeAnalysis());
        }
    }
}
