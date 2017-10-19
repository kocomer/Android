package com.kocomer.pay.manager.fragment.store;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeOption;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiDetailResult;
import com.baidu.mapapi.search.poi.PoiIndoorResult;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.mapapi.search.poi.PoiResult;
import com.baidu.mapapi.search.poi.PoiSearch;
import com.kocomer.core.fragment.ContentFragment;
import com.kocomer.core.helper.Constants;
import com.kocomer.map.fragment.MapFragment;
import com.kocomer.pay.R;
import com.kocomer.pay.analysis.PayStoreAnalysis;
import com.kocomer.pay.entity.PayStoreEntity;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreFragment extends ContentFragment implements View.OnClickListener, BaiduMap.OnMapClickListener {
    private MapView mapView;
    private LocationClient mLocationClient;
    private BaiduMap baiduMap;
    private EditText searchEt;
    private EditText nameEt;
    private EditText provinceEt;
    private EditText cityEt;
    private EditText districtEt;
    private EditText addressEt;
    private EditText longitudeEt;
    private EditText latitudeEt;
    private EditText linkNameEt;
    private EditText phoneEt;
    public BDAbstractLocationListener myListener = new BDAbstractLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            System.out.println("333");

            baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(new LatLng(bdLocation.getLongitude(), bdLocation.getLatitude())));

            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
                    .fromResource(com.kocomer.map.R.drawable.icon_geo);
            MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, bitmapDescriptor);
            baiduMap.setMyLocationConfiguration(config);

        }

        @Override
        public void onLocDiagnosticMessage(int locType, int diagnosticType, String diagnosticMessage) {
            System.out.println("444444");
        }
    };

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mLocationClient.stop();
    }

    @Override
    protected String setPageName() {
        return "PayStore";
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Context context = getActivity().getApplicationContext();
        SDKInitializer.initialize(context);
        mLocationClient = new LocationClient(context);
        mLocationClient.registerLocationListener(myListener);

        LocationClientOption option = new LocationClientOption();
        option.setLocationMode(LocationClientOption.LocationMode.Battery_Saving);
        option.setIsNeedAddress(true);
        mLocationClient.setLocOption(option);

        mLocationClient.start();

        View view = inflater.inflate(R.layout.fragment_pay_store_content, null);
        view.findViewById(R.id.fragment_pay_store_search_tv).setOnClickListener(this);
        searchEt = (EditText) view.findViewById(R.id.fragment_pay_store_search_et);
        nameEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_name_et);
        provinceEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_province_et);
        cityEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_city_et);
        districtEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_district_et);
        addressEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_address_et);
        longitudeEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_longitude_et);
        latitudeEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_latitude_et);
        linkNameEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_linkname_et);
        phoneEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_phone_et);
        view.findViewById(R.id.fragment_pay_store_content_submit_tv).setOnClickListener(this);

        mapView = (MapView) view.findViewById(R.id.fragment_pay_store_map);

        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        baiduMap.setOnMapClickListener(this);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("isStarted = " + mLocationClient.isStarted());
    }

    @Override
    public void onMapClick(final LatLng latLng) {
        final GeoCoder geoCoder = GeoCoder.newInstance();
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                System.out.println("1111111111111");
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null
                        || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {


                    // 没有检测到结果
                } else {
                    ReverseGeoCodeResult.AddressComponent addressComponent = reverseGeoCodeResult.getAddressDetail();
                    provinceEt.setText(addressComponent.province);
                    cityEt.setText(addressComponent.city);
                    districtEt.setText(addressComponent.district);
                    addressEt.setText(addressComponent.street);
                    longitudeEt.setText(latLng.longitude + "");
                    latitudeEt.setText(latLng.latitude + "");

                }
                geoCoder.destroy();
            }
        });
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
    }

    @Override
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_pay_store_search_tv) {
            final String point = searchEt.getText().toString();
            final GeoCoder geoCoder = GeoCoder.newInstance();
            geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
                @Override
                public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                    if (geoCodeResult == null
                            || geoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                        System.out.println("333333333");
                        // 没有检测到结果
                    } else {
                        System.out.println("fffffffffffffffffff");
                        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(geoCodeResult.getLocation()));
                    }
                    geoCoder.destroy();
                }

                @Override
                public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                    if (reverseGeoCodeResult == null
                            || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                        System.out.println("333333333");
                        // 没有检测到结果
                    } else {
                        System.out.println("fffffffffffffffffff");
                        baiduMap.setMyLocationData(new MyLocationData.Builder().latitude(reverseGeoCodeResult.getLocation().latitude).longitude(reverseGeoCodeResult.getLocation().longitude).build());

                    }
                    geoCoder.destroy();
                }

            });
            geoCoder.geocode(new GeoCodeOption().address(point).city("深圳"));
        } else if (id == R.id.fragment_pay_store_content_submit_tv) {
            String province = provinceEt.getText().toString();
            String city = cityEt.getText().toString();
            String district = districtEt.getText().toString();
            String address = addressEt.getText().toString();
            String name = nameEt.getText().toString();
            String linkName = linkNameEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String longitude = longitudeEt.getText().toString();
            String latitude = latitudeEt.getText().toString();
            HashMap<String, String> params = new HashMap<>();

            params.put("name", name);
            params.put("province", province);
            params.put("city", city);
            params.put("district", district);
            params.put("address", address);
            params.put("linkName", linkName);
            params.put("phone", phone);
            params.put("longitude", longitude);
            params.put("latitude", latitude);
            loadContent(Constants.STR_URL + "/pay_store.json", params, new PayStoreAnalysis());

        }

    }

    @Override
    public void onContentLoaded(Object entity) {
        if (entity instanceof PayStoreEntity) {
            showMsg("创建完成");
        }
    }
}
