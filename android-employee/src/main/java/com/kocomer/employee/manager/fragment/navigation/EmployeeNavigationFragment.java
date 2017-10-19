package com.kocomer.employee.manager.fragment.navigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.employee.R;

/**
 * Created by kocomer on 2017/8/26.
 */

public class EmployeeNavigationFragment extends BaseFragment {
    private RelativeLayout navigationLayout;

    @Override
    protected String setPageName() {
        return "EmployeeNavigation";
    }

    private ImageView imageView;

    @Override
    public void normalCallback() {
        imageView.setImageResource(R.drawable.employee_normal);
    }

    @Override
    public void selectedCallback() {
        imageView.setImageResource(R.drawable.employee_selected);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        navigationLayout = (RelativeLayout) inflater.inflate(R.layout.fragment_employee_navigation, null);
        imageView = (ImageView) navigationLayout.findViewById(R.id.fragment_employee_navigation_icon_iv);
        return navigationLayout;
    }


}