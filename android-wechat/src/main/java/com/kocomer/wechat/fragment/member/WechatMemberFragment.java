package com.kocomer.wechat.fragment.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageCache;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatMemberAnalysis;
import com.kocomer.wechat.entity.WechatMemberEntity;

import org.w3c.dom.Text;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/7/18.
 */

public class WechatMemberFragment extends ContentFragment implements View.OnClickListener {
    public String code;//会员编码
    private LinearLayout contentLayout;
    private ImageView headerIv;//头像
    private TextView nickNameTv;
    private ImageLoader imageLoader;
    private Button submitBtn;
    private EditText balanceEt;
    private EditText pointEt;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_member, null);
        headerIv = (ImageView) contentLayout.findViewById(R.id.fragment_wechat_member_header_iv);
        submitBtn = (Button) contentLayout.findViewById(R.id.fragment_wechat_member_submit);
        balanceEt = (EditText) contentLayout.findViewById(R.id.fragment_wechat_member_balance_et);
        pointEt = (EditText) contentLayout.findViewById(R.id.fragment_wechat_member_point_et);

        submitBtn.setOnClickListener(this);
        nickNameTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_member_nickname_tv);
        loadContent(Request.Method.GET, Constants.STR_URL + "/wechat_scanmember.json?cardCode=" + code, null, new WechatMemberAnalysis());
        imageLoader = new ImageLoader(queue, new ImageCache());
        return contentLayout;
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof WechatMemberEntity) {
            WechatMemberEntity wechatMemberEntity = (WechatMemberEntity) entity;

            ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(headerIv, R.drawable.share_via_barcode, R.drawable.launcher_icon);
            imageLoader.get(wechatMemberEntity.header, imageListener);

        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_wechat_member_submit) {
            String balance = balanceEt.getText().toString();
            String point = pointEt.getText().toString();

        }
    }
}
