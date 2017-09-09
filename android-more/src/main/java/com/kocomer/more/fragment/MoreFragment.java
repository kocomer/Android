package com.kocomer.more.fragment;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.more.R;
import com.kocomer.more.activity.MoreAboutActivity;
import com.kocomer.more.activity.MoreFeedbackActivity;
import com.kocomer.more.activity.MoreHelpActivity;
import com.kocomer.more.activity.MoreSecretActivity;
import com.kocomer.more.activity.MoreVersionActivity;
import com.kocomer.more.fragment.about.MoreAboutFragment;
import com.kocomer.more.fragment.feedback.MoreFeedbackFragment;
import com.kocomer.more.fragment.help.MoreHelpFragment;

/**
 * Created by kocomer on 2017/8/28.
 */

public class MoreFragment extends BaseFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Setting";
    }

    private LinearLayout layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, null);
        layout = (LinearLayout) view.findViewById(R.id.fragment_pay_content_ll);
        inflater.inflate(R.layout.fragment_more_secret, layout).findViewById(R.id.fragment_more_secret_ll).setOnClickListener(this);
        inflater.inflate(R.layout.fragment_more_help, layout).findViewById(R.id.fragment_more_help_ll).setOnClickListener(this);
        inflater.inflate(R.layout.fragment_more_feedback, layout).findViewById(R.id.fragment_more_feedback_ll).setOnClickListener(this);
        inflater.inflate(R.layout.fragment_more_about, layout).findViewById(R.id.fragment_more_about_ll).setOnClickListener(this);
        inflater.inflate(R.layout.fragment_more_version, layout).findViewById(R.id.fragment_more_version_ll).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_more_help_ll) {
            startActivity(new Intent(getActivity(), MoreHelpActivity.class));
        } else if (id == R.id.fragment_more_feedback_ll) {
            startActivity(new Intent(getActivity(), MoreFeedbackActivity.class));
        } else if (id == R.id.fragment_more_about_ll) {
            startActivity(new Intent(getActivity(), MoreAboutActivity.class));
        } else if (id == R.id.fragment_more_version_ll) {
            startActivity(new Intent(getActivity(), MoreVersionActivity.class));
        } else if (id == R.id.fragment_more_secret_ll) {
            startActivity(new Intent(getActivity(), MoreSecretActivity.class));
        }
    }
}
