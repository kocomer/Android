package com.kocomer.repair.manager.fragment.task;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.analysis.Analysis;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.repair.R;
import com.kocomer.repair.analysis.RepairTaskAnalysis;
import com.kocomer.repair.entity.RepairTaskEntity;

/**
 * Created by kocomer on 2017/9/19.
 */

public class RepairTaskFragment extends PageFragment<RepairTaskEntity> {
    private ListView taskLv;

    @Override
    protected String setPageName() {
        return "RepairTask";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repair_task, null);
        taskLv = (ListView) view.findViewById(R.id.fragment_repair_task_lv);

        AlarmManager am = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent("xxx");
        PendingIntent sender = PendingIntent.getBroadcast(getActivity(), 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
//        am.setRepeating(...);
        return view;
    }

    @Override
    public String getPageId() {
        return "RepairTask";
    }

    @Override
    public String getURL() {
        return Constants.STR_URL + "/repair_task.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new RepairTaskAnalysis();
    }

    @Override
    public void onPageLoaded(RepairTaskEntity entity) {

    }
}
