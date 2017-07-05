package com.kocomer.wechat.fragment.cell;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.zxing.client.android.CaptureActivity;
import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.wechat.R;

/**
 * 微信扫会员卡
 * Created by kocomer on 2017/3/28.
 */

public class WechatScanMemberFragment extends ContentFragment implements View.OnClickListener {
    private LinearLayout scanmenberLayout;
    private static final int SCANMEMBER = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        scanmenberLayout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat_scanmember, null);
        scanmenberLayout.setOnClickListener(this);
        return scanmenberLayout;
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fragment_wechat_scanmember_ll) {
            Intent intent = new Intent(getActivity(), CaptureActivity.class);
            startActivityForResult(intent, SCANMEMBER);
            System.out.println("fragment_wechat_scanmember_rl click");
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SCANMEMBER: {

            }
            break;
        }
    }
}
