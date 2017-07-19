package com.kocomer.wechat.fragment;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.Intents;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.wechat.R;
import com.kocomer.wechat.activity.WechatHistoryActivity;
import com.kocomer.wechat.activity.WechatMemberActivity;
import com.kocomer.wechat.activity.WechatScanMemberActivity;
import com.kocomer.wechat.helper.WechatConstants;

/**
 * Created by kocomer on 2017/3/26.
 */

public class WechatFragment extends ContentFragment implements View.OnClickListener {
    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout scancardLinearLayout;

    private ModulesEntity.Module.Cell[] cells;

    public void setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_wechat, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_wechat_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            switch (cell.code) {
                case WechatConstants.CELL_WECHAT_SCANMEMBER: {//微信扫会员卡
                    inflater.inflate(R.layout.fragment_wechat_scanmember, contentLayout).findViewById(R.id.fragment_wechat_scanmember_ll).setOnClickListener(this);
                }
                break;
                case WechatConstants.CELL_WECHAT_SCANCARD: {
                    inflater.inflate(R.layout.fragment_wechat_scancard, contentLayout).findViewById(R.id.fragment_wechat_scancard_ll).setOnClickListener(this);
                }
                break;
                case WechatConstants.CELL_WECHAT_MEMBER: {
                    inflater.inflate(R.layout.fragment_wechat_member, contentLayout).findViewById(R.id.fragment_wechat_member_ll).setOnClickListener(this);
                }
                break;
                case WechatConstants.CELL_WECHAT_HISTORY: {
                    inflater.inflate(R.layout.fragment_wechat_history, contentLayout).findViewById(R.id.fragment_wechat_history_ll).setOnClickListener(this);
                }
                break;
            }
        }
        return layout;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //这里已经获取到了摄像头的权限，想干嘛干嘛了可以
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), CaptureActivity.class);
                    intent.setAction(Intents.Scan.ACTION);
                    startActivityForResult(intent, WechatConstants.REQUESTCODE_MEMBERCARD);
                } else {
                    //这里是拒绝给APP摄像头权限，给个提示什么的说明一下都可以。
                    Toast.makeText(getActivity(), "请手动打开相机权限", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case WechatConstants.REQUESTCODE_MEMBERCARD: {
                String result = data.getStringExtra("result");
                System.out.println("result = " + result);

                if (result != null && !"".equals(result)) {
                    Intent intent = new Intent(getActivity(), WechatScanMemberActivity.class);
                    intent.putExtra("code", result);
                    startActivity(intent);
                }
            }
            break;
        }
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_wechat_scanmember_ll) {//点击扫描会员卡
            if (Build.VERSION.SDK_INT > 22) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    //先判断有没有权限 ，没有就在这里进行权限的申请
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{android.Manifest.permission.CAMERA}, 0);

                } else {
                    Intent intent = new Intent();
                    intent.setClass(getActivity(), CaptureActivity.class);
                    intent.setAction(Intents.Scan.ACTION);
                    startActivityForResult(intent, WechatConstants.REQUESTCODE_MEMBERCARD);
                }
            } else {
                Intent intent = new Intent();
                intent.setClass(getActivity(), CaptureActivity.class);
                intent.setAction(Intents.Scan.ACTION);
                startActivityForResult(intent, WechatConstants.REQUESTCODE_MEMBERCARD);
            }

        } else if (i == R.id.fragment_wechat_scancard_ll) {//点击扫描营销卡

        } else if (i == R.id.fragment_wechat_member_ll) {//点击会员列表
            startActivity(new Intent(getActivity(), WechatMemberActivity.class));
        } else if (i == R.id.fragment_wechat_history_ll) {//点击操作日志
            startActivity(new Intent(getActivity(), WechatHistoryActivity.class));
        }
    }
}
