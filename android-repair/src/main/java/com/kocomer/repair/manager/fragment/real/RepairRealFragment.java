package com.kocomer.repair.manager.fragment.real;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

/**
 * Created by kocomer on 2017/9/20.
 */

public class RepairRealFragment extends ContentFragment implements View.OnClickListener {
    private ImageView frontIv;
    private ImageView reverseIv;
    private EditText loginNameEt;
    private EditText nameEt;
    private EditText noEt;
    private EditText phoneEt;
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
        frontIv.setOnClickListener(this);

        reverseIv = (ImageView) view.findViewById(R.id.fragment_repair_real_content_reverse_iv);
        reverseIv.setOnClickListener(this);

        view.findViewById(R.id.fragment_repair_real_content_submit_tv).setOnClickListener(this);
        nameEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_name_et);
        loginNameEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_loginname_et);
        noEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_no_et);
        phoneEt = (EditText) view.findViewById(R.id.fragment_repair_real_content_phone_et);
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1) {

        } else if (requestCode == 2) {

        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_repair_real_content_front_iv) {//正面
            Intent intent = new Intent();
            // 指定开启系统相机的Action
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            // 根据文件地址创建文件
            File file = new File("front.png");
            // 把文件地址转换成Uri格式
            Uri uri = Uri.fromFile(file);
            // 设置系统相机拍摄照片完成后图片文件的存放地址
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, 1);
        } else if (id == R.id.fragment_repair_real_content_reverse_iv) {//反面
            Intent intent = new Intent();
            // 指定开启系统相机的Action
            intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.addCategory(Intent.CATEGORY_DEFAULT);
            // 根据文件地址创建文件
            File file = new File("reverse.png");
            // 把文件地址转换成Uri格式
            Uri uri = Uri.fromFile(file);
            // 设置系统相机拍摄照片完成后图片文件的存放地址
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
            startActivityForResult(intent, 2);

        } else if (id == R.id.fragment_repair_real_content_submit_tv) {//提交
            String loginName = loginNameEt.getText().toString();
            String name = nameEt.getText().toString();
            String no = noEt.getText().toString();
            String phone = phoneEt.getText().toString();

            if (StringUtils.isAnyEmpty(loginName, name, no, phone)) {
                showMsg("字段缺失");
                return;
            }

            if (front == null || reverse == null) {
                showMsg("选择身份证");
                return;
            }
            HashMap<String, String> params = new HashMap<>();

            OkHttpClient client = new OkHttpClient();
            MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
            builder.addFormDataPart("loginName", loginName);
            builder.addFormDataPart("name", name);
            builder.addFormDataPart("no", no);
            builder.addFormDataPart("phone", phone);

            builder.addFormDataPart("front", "front", RequestBody.create(MediaType.parse("image/png"), new byte[]{}));
            builder.addFormDataPart("reverse", "reverse", RequestBody.create(MediaType.parse("image/png"), new byte[]{}));


            loadContent(Request.Method.POST, Constants.STR_URL + "/", params, new ImageHelper[]{new ImageHelper("front", front)}, null, null);


        }
    }
}
