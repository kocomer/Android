package com.kocomer.employee.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.employee.R;
import com.kocomer.employee.helper.EmployeeConstants;

/**
 * Created by kocomer on 2017/8/26.
 */

public class EmployeeFragment extends ContentFragment implements View.OnClickListener {
    @Override
    protected String setPageName() {
        return "Employee";
    }

    private LinearLayout layout;
    private LinearLayout contentLayout;
    private LinearLayout scancardLinearLayout;

    private ModulesEntity.Module.Cell[] cells;

    public EmployeeFragment setCells(ModulesEntity.Module.Cell[] cells) {
        this.cells = cells;
        return this;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (LinearLayout) inflater.inflate(R.layout.fragment_employee, null);
        contentLayout = (LinearLayout) layout.findViewById(R.id.fragment_employee_content_ll);
        int length = cells.length;
        for (int i = 0; i < length; i++) {
            final ModulesEntity.Module.Cell cell = cells[i];
            System.out.println("code === " + cell.code);
            switch (cell.code) {
                case EmployeeConstants.CELL_EMPLOYEE_EMPLOYEELIST: {//雇员列表
                    inflater.inflate(R.layout.fragment_employee_list, contentLayout).findViewById(R.id.fragment_employee_list_ll).setOnClickListener(this);
                }
                break;

            }
        }
        return layout;
    }


    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.fragment_employee_list_ll) {//
//            startActivity(new Intent(getActivity(), PayScanWechatActivity.class));
        }
    }
}