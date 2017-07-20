package com.kocomer.wechat.fragment.memberlist;

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
 * Created by kocomer on 2017/7/18.
 */

public class WechatMemberListFragment extends ContentFragment implements View.OnClickListener {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wechat_memberlist_content, null);
    }
}
