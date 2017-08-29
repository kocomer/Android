package com.kocomer.wechat.fragment.scanmember;

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
import com.android.volley.toolbox.ImageLoader;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageCache;
import com.kocomer.wechat.R;
import com.kocomer.wechat.analysis.WechatMemberAnalysis;
import com.kocomer.wechat.analysis.WechatMemberUpdateAnalysis;
import com.kocomer.wechat.entity.WechatMemberEntity;
import com.kocomer.wechat.entity.WechatMemberUpdateEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/7/20.
 */

public class WechatScanMemberFragment extends ContentFragment implements View.OnClickListener {
    public String code;//会员编码
    private LinearLayout contentLayout;
    private ImageView headerIv;//头像
    private TextView nickNameTv;
    private TextView pointTv;
    private TextView balanceTv;
    private ImageLoader imageLoader;
    private Button submitBtn;
    private EditText balanceEt;
    private EditText pointEt;

    @Override
    protected String setPageName() {
        return "WechatScanMember";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        contentLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_scanmember_content, null);
        headerIv = (ImageView) contentLayout.findViewById(R.id.fragment_wechat_scanmember_header_iv);
        submitBtn = (Button) contentLayout.findViewById(R.id.fragment_wechat_member_submit);
        balanceEt = (EditText) contentLayout.findViewById(R.id.fragment_wechat_member_balance_et);
        pointEt = (EditText) contentLayout.findViewById(R.id.fragment_wechat_member_point_et);

        submitBtn.setOnClickListener(this);
        nickNameTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scanmember_nickname_tv);
        pointTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scanmember_point_tv);
        balanceTv = (TextView) contentLayout.findViewById(R.id.fragment_wechat_scanmember_balance_tv);

        loadContent(Request.Method.GET, Constants.STR_URL + "/wechat_scanMember.json?cardCode=" + code, null, new WechatMemberAnalysis());
        imageLoader = new ImageLoader(queue, new ImageCache());
        return contentLayout;
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof WechatMemberEntity) {
            WechatMemberEntity wechatMemberEntity = (WechatMemberEntity) entity;
            pointTv.setText(wechatMemberEntity.point);
            balanceTv.setText(wechatMemberEntity.balance);

            ImageLoader.ImageListener imageListener = ImageLoader.getImageListener(headerIv, R.drawable.loading, R.drawable.error);
            imageLoader.get(wechatMemberEntity.header, imageListener);

        } else if (entity instanceof WechatMemberUpdateEntity) {
            WechatMemberUpdateEntity wechatMemberUpdateEntity = (WechatMemberUpdateEntity) entity;
            showMsg("更新成功");
        }
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_wechat_member_submit) {
            String balance = balanceEt.getText().toString();
            String point = pointEt.getText().toString();

            HashMap<String, String> params = new HashMap<>();
            params.put("balance", balance);
            params.put("point", point);
            params.put("cardCode", code);
            loadContent(Constants.STR_URL + "/wechat_scanMember.json", params, new WechatMemberUpdateAnalysis());
        }
    }
}
