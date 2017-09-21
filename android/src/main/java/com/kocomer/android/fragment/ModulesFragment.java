package com.kocomer.android.fragment;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.android.volley.analysis.Analysis;
import com.kocomer.android.R;
import com.kocomer.android.helper.Constants;
import com.kocomer.delivery.manager.fragment.DeliveryFragment;
import com.kocomer.delivery.manager.fragment.navigation.DeliveryNavigationFragment;
import com.kocomer.employee.fragment.EmployeeFragment;
import com.kocomer.employee.fragment.navigation.EmployeeNavigationFragment;
import com.kocomer.iot.manager.fragment.IotFragment;
import com.kocomer.iot.manager.fragment.navigation.IotNavigationFragment;
import com.kocomer.mall.manager.MallFragment;
import com.kocomer.mall.manager.fragment.navigation.MallNavigationFragment;
import com.kocomer.message.fragment.MessageFragment;
import com.kocomer.message.fragment.navigation.MessageNavigationFragment;
import com.kocomer.more.fragment.MoreFragment;
import com.kocomer.more.fragment.navigation.MoreNavigationFragment;
import com.kocomer.pay.manager.fragment.PayFragment;
import com.kocomer.pay.manager.fragment.navigation.PayNavigationFragment;
import com.kocomer.core.analysis.ModulesAnalysis;
import com.kocomer.core.entity.ModulesEntity;
import com.kocomer.core.fragment.PageFragment;
import com.kocomer.corporation.fragment.CorporationFragment;
import com.kocomer.corporation.fragment.navigation.CorporationNavigationFragment;
import com.kocomer.repair.manager.fragment.RepairFragment;
import com.kocomer.repair.manager.fragment.navigation.RepairNavigationFragment;
import com.kocomer.wechat.fragment.WechatFragment;
import com.kocomer.wechat.fragment.navigation.WechatNavigationFragment;
import com.umeng.analytics.MobclickAgent;

/**
 * 模块插件
 */
public class ModulesFragment extends PageFragment<ModulesEntity> implements View.OnClickListener {
    private RelativeLayout layout;
    private RelativeLayout footLayout;
    private LinearLayout bodyLayout;

    @Override
    protected String setPageName() {
        return "Modules";
    }

    private RelativeLayout wechatNavigationLayout;
    private RelativeLayout corporationNavigationLayout;
    private RelativeLayout payNavigationLayout;
    private RelativeLayout messageNavigationLayout;
    private RelativeLayout employeeNavigationLayout;
    private RelativeLayout moreNavigationLayout;
    private RelativeLayout iotNavigationLayout;
    private RelativeLayout mallNavigationLayout;
    private RelativeLayout deliveryNavigationLayout;
    private RelativeLayout repairNavigationLayout;

    private ModulesEntity modulesEntity;


    //微信管理导航
    private WechatNavigationFragment wechatNavigationFragment;
    //公司管理导航
    private CorporationNavigationFragment corporationNavigationFragment;
    //支付管理导航
    private PayNavigationFragment payNavigationFragment;
    //消息管理导航
    private MessageNavigationFragment messageNavigationFragment;
    //雇员管理导航
    private EmployeeNavigationFragment employeeNavigationFragment;
    //更多导航
    private MoreNavigationFragment moreNavigationFragment;
    //设备管理导航
    private IotNavigationFragment iotNavigationFragment;
    //商城管理导航
    private MallNavigationFragment mallNavigationFragment;
    //物流管理导航
    private DeliveryNavigationFragment deliveryNavigationFragment;
    //维修管理导航
    private RepairNavigationFragment repairNavigationFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        layout = (RelativeLayout) inflater.inflate(R.layout.fragment_modules, null);
        footLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_rl);
        bodyLayout = (LinearLayout) layout.findViewById(R.id.fragment_modules_body_ll);

        repairNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_repair_rl);
        wechatNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_wechat_rl);
        corporationNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_corporation_rl);
        payNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_pay_rl);
        messageNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_message_rl);
        employeeNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_employee_rl);
        moreNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_more_rl);
        iotNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_iot_rl);
        mallNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_mall_rl);
        deliveryNavigationLayout = (RelativeLayout) layout.findViewById(R.id.fragment_modules_foot_delivery_rl);

        repairNavigationLayout.setOnClickListener(this);
        wechatNavigationLayout.setOnClickListener(this);
        corporationNavigationLayout.setOnClickListener(this);
        payNavigationLayout.setOnClickListener(this);
        messageNavigationLayout.setOnClickListener(this);
        employeeNavigationLayout.setOnClickListener(this);
        moreNavigationLayout.setOnClickListener(this);
        iotNavigationLayout.setOnClickListener(this);
        mallNavigationLayout.setOnClickListener(this);
        deliveryNavigationLayout.setOnClickListener(this);
        return layout;
    }


    @Override
    public String getPageId() {
        return "modules";
    }

    @Override
    public String getURL() {
        return com.kocomer.core.helper.Constants.STR_URL + "/modules.json";
    }

    @Override
    public Analysis getAnalysis() {
        return new ModulesAnalysis();
    }

    @Override
    public void onPageLoaded(ModulesEntity entity) {
        modulesEntity = entity;
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        WelcomeFragment welcomeFragment = new WelcomeFragment();
        ft.replace(R.id.fragment_modules_body_ll, welcomeFragment);

        for (int i = 0, length = entity.module.length; i < length; i++) {
            ModulesEntity.Module module = entity.module[i];
            if (Constants.MODULE_WECHAT.equals(module.code)) {//微信营销模块
                wechatNavigationLayout.setVisibility(View.VISIBLE);
                wechatNavigationFragment = new WechatNavigationFragment();
                ft.add(R.id.fragment_modules_foot_wechat_rl, wechatNavigationFragment);
            } else if (Constants.MODULE_CORPORATION.equals(module.code)) {//公司中心
                corporationNavigationLayout.setVisibility(View.VISIBLE);
                corporationNavigationFragment = new CorporationNavigationFragment();
                ft.add(R.id.fragment_modules_foot_corporation_rl, corporationNavigationFragment);
            } else if (Constants.MODULE_PAY.equals(module.code)) {
                payNavigationFragment = new PayNavigationFragment();
                ft.add(R.id.fragment_modules_foot_pay_rl, payNavigationFragment);
                payNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_MESSAGE.equals(module.code)) {
                messageNavigationFragment = new MessageNavigationFragment();
                ft.add(R.id.fragment_modules_foot_message_rl, messageNavigationFragment);
                messageNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_EMPLOYEE.equals(module.code)) {
                employeeNavigationFragment = new EmployeeNavigationFragment();
                ft.add(R.id.fragment_modules_foot_employee_rl, employeeNavigationFragment);
                employeeNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_IOT.equals(module.code)) {
                iotNavigationFragment = new IotNavigationFragment();
                ft.add(R.id.fragment_modules_foot_iot_rl, iotNavigationFragment);
                iotNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_MALL.equals(module.code)) {//商城管理
                mallNavigationFragment = new MallNavigationFragment();
                ft.add(R.id.fragment_modules_foot_mall_rl, mallNavigationFragment);
                mallNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_DELIVERY.equals(module.code)) {//配送管理
                deliveryNavigationFragment = new DeliveryNavigationFragment();
                ft.add(R.id.fragment_modules_foot_delivery_rl, deliveryNavigationFragment);
                deliveryNavigationLayout.setVisibility(View.VISIBLE);
            } else if (Constants.MODULE_REPAIR.equals(module.code)) {//维修管理
                repairNavigationFragment = new RepairNavigationFragment();
                ft.add(R.id.fragment_modules_foot_repair_rl, repairNavigationFragment);
                repairNavigationLayout.setVisibility(View.VISIBLE);
            }

        }
        moreNavigationFragment = new MoreNavigationFragment();
        ft.add(R.id.fragment_modules_foot_more_rl, moreNavigationFragment);
        moreNavigationLayout.setVisibility(View.VISIBLE);
        ft.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();

        if (wechatNavigationFragment != null) {
            wechatNavigationFragment.normalCallback();
        }
        if (corporationNavigationFragment != null) {
            corporationNavigationFragment.normalCallback();
        }
        if (payNavigationFragment != null) {
            payNavigationFragment.normalCallback();
        }
        if (messageNavigationFragment != null) {
            messageNavigationFragment.normalCallback();
        }
        if (employeeNavigationFragment != null) {
            employeeNavigationFragment.normalCallback();
        }
        if (iotNavigationFragment != null) {
            iotNavigationFragment.normalCallback();
        }
        if (mallNavigationFragment != null) {
            mallNavigationFragment.normalCallback();
        }
        if (deliveryNavigationFragment != null) {
            deliveryNavigationFragment.normalCallback();
        }
        if (repairNavigationFragment != null) {
            repairNavigationFragment.normalCallback();
        }
        moreNavigationFragment.normalCallback();

        switch (v.getId()) {
            case R.id.fragment_modules_foot_repair_rl: {
                MobclickAgent.onEvent(getActivity(), "Repair");
                repairNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new RepairFragment().setCells(getCells(modulesEntity, Constants.MODULE_REPAIR)));

            }
            break;
            case R.id.fragment_modules_foot_more_rl: {
                MobclickAgent.onEvent(getActivity(), "More");
                moreNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new MoreFragment());

            }
            break;
            case R.id.fragment_modules_foot_wechat_rl: {
                MobclickAgent.onEvent(getActivity(), "Wechat");
                wechatNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new WechatFragment().setCells(getCells(modulesEntity, Constants.MODULE_WECHAT)));
            }
            break;
            case R.id.fragment_modules_foot_corporation_rl: {
                MobclickAgent.onEvent(getActivity(), "Corporation");
                corporationNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new CorporationFragment().setCells(getCells(modulesEntity, Constants.MODULE_CORPORATION)));
            }
            break;
            case R.id.fragment_modules_foot_pay_rl: {
                MobclickAgent.onEvent(getActivity(), "Pay");
                payNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new PayFragment().setCells(getCells(modulesEntity, Constants.MODULE_PAY)));
            }
            break;
            case R.id.fragment_modules_foot_message_rl: {
                MobclickAgent.onEvent(getActivity(), "Message");
                messageNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new MessageFragment().setCells(getCells(modulesEntity, Constants.MODULE_MESSAGE)));
            }
            break;
            case R.id.fragment_modules_foot_employee_rl: {
                MobclickAgent.onEvent(getActivity(), "Employee");
                employeeNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new EmployeeFragment().setCells(getCells(modulesEntity, Constants.MODULE_PAY)));

            }
            break;
            case R.id.fragment_modules_foot_iot_rl: {
                MobclickAgent.onEvent(getActivity(), "Iot");
                iotNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new IotFragment().setCells(getCells(modulesEntity, Constants.MODULE_IOT)));
            }
            break;
            case R.id.fragment_modules_foot_mall_rl: {
                MobclickAgent.onEvent(getActivity(), "Mall");
                mallNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new MallFragment().setCells(getCells(modulesEntity, Constants.MODULE_MALL)));
            }
            break;
            case R.id.fragment_modules_foot_delivery_rl: {
                MobclickAgent.onEvent(getActivity(), "Delivery");
                deliveryNavigationFragment.selectedCallback();
                ft.replace(R.id.fragment_modules_body_ll, new DeliveryFragment().setCells(getCells(modulesEntity, Constants.MODULE_DELIVERY)));
            }
            break;
        }
        ft.commit();

    }

    private ModulesEntity.Module.Cell[] getCells(ModulesEntity modulesEntity, String code) {
        int length = modulesEntity.module.length;
        for (int i = 0; i < length; i++) {
            if (code.equals(modulesEntity.module[i].code)) {
                return modulesEntity.module[i].cells;
            }
        }
        return null;
    }
}
