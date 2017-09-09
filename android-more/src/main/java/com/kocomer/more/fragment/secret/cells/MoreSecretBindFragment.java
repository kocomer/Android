package com.kocomer.more.fragment.secret.cells;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.more.R;
import com.kocomer.more.analysis.MoreSecretBindAnalysis;
import com.kocomer.more.entity.MoreSecretBindEntity;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/8/30.
 */

public class MoreSecretBindFragment extends PageFragment<MoreSecretBindEntity> implements View.OnClickListener {
    private TextView statusTv;

    @Override
    protected String setPageName() {
        return "MoreSecretBind";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more_secret_bind_content, null);
        statusTv = (TextView) view.findViewById(R.id.fragment_more_secret_bind_content_status_tv);
        statusTv.setOnClickListener(this);
        return view;
    }

    @Override
    public String getPageId() {
        return "MoreSecretBind";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/bind.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new MoreSecretBindAnalysis();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_more_secret_bind_content_status_tv) {
            Boolean status = (Boolean) v.getTag();

            if (status != null) {
                HashMap<String, String> params = new HashMap<>();
                params.put("bind", status ? "0" : "1");
                loadContent(Constants.STR_URL + "/bind.json", params, new MoreSecretBindAnalysis());
            }
        }
    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof MoreSecretBindEntity) {
            MoreSecretBindEntity moreSecretBindEntity = (MoreSecretBindEntity) entity;
            if (moreSecretBindEntity.bind) {
                statusTv.setBackgroundResource(R.drawable.switch_selected);
                statusTv.setTag(true);
            } else {
                statusTv.setBackgroundResource(R.drawable.switch_normal);
                statusTv.setTag(false);
            }
        }
    }

    @Override
    public void onPageLoaded(MoreSecretBindEntity entity) {
        if (entity.bind) {
            statusTv.setBackgroundResource(R.drawable.switch_selected);
            statusTv.setTag(true);
        } else {
            statusTv.setBackgroundResource(R.drawable.switch_normal);
            statusTv.setTag(false);
        }
    }
}
