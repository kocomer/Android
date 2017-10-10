package com.kocomer.repair.manager.fragment.real;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.Request;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.core.helper.ImageHelper;
import com.kocomer.repair.R;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairRealFragment extends ContentFragment implements View.OnClickListener {
    private ImageView frontIv;
    private ImageView reverseIv;
    private EditText nameEt;
    private EditText noEt;
    private EditText phoneEt;
    private EditText verifyEt;
    private byte[] front;
    private byte[] reverse;

    @Override
    protected String setPageName() {
        return "RepairReal";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repair_real_content, null);
        frontIv = (ImageView) view.findViewById(R.id.fragment_repair_real_content_front_iv);
        reverseIv = (ImageView) view.findViewById(R.id.fragment_repair_real_content_reverse_iv);
        view.findViewById(R.id.fragment_repair_real_content_submit_tv).setOnClickListener(this);
        nameEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_name_et);
        noEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_no_et);
        phoneEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_phone_et);
        verifyEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_verify_et);
        return view;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_repair_real_content_front_iv) {//正面

        } else if (id == R.id.fragment_repair_real_content_reverse_iv) {//反面

        } else if (id == R.id.fragment_repair_real_content_submit_tv) {//提交
            String name = nameEt.getText().toString();
            String no = noEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String verify = verifyEt.getText().toString();
            if ("".equals(name) || "".equals(no) || "".equals(phone) || "".equals(verify)) {
                showMsg("字段缺失");
                return;
            }

            if (front == null || reverse == null) {
                showMsg("选择身份证");
                return;
            }
            HashMap<String, String> params = new HashMap<>();

            loadContent(Request.Method.POST, Constants.STR_URL + "/", params, new ImageHelper[]{new ImageHelper("front", front)}, null, null);

        }
    }
}
