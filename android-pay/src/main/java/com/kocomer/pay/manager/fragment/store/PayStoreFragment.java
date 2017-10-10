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

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.SupportMapFragment;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
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
import com.kocomer.map.fragment.MapFragment;
import com.kocomer.pay.R;

/**
 * Created by kocomer on 2017/9/22.
 */

public class PayStoreFragment extends ContentFragment implements View.OnClickListener, BaiduMap.OnMapClickListener {
    private MapView mapView;
    private LocationClient mLocationClient;
    private BaiduMap baiduMap;
    private EditText searchEt;
    private EditText provinceEt;
    private EditText cityEt;
    private EditText disttrictEt;

    public BDAbstractLocationListener myListener = new BDAbstractLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            System.out.println("yyyyyyyyyyyyyyyyyyyyyy");
            MyLocationData locData = new MyLocationData.Builder()
                    .accuracy(bdLocation.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(100).latitude(bdLocation.getLatitude())
                    .longitude(bdLocation.getLongitude()).build();
            baiduMap.setMyLocationData(locData);

            BitmapDescriptor bitmapDescriptor = BitmapDescriptorFactory
                    .fromResource(com.kocomer.map.R.drawable.icon_geo);
            MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, bitmapDescriptor);
            baiduMap.setMyLocationConfiguration(config);

        }

        @Override
        public void onLocDiagnosticMessage(int locType, int diagnosticType, String diagnosticMessage) {
            System.out.println("zzzzzzzzzzzzzzzzzzz");
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
        provinceEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_province_et);
        cityEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_city_et);
        disttrictEt = (EditText) view.findViewById(R.id.fragment_pay_store_content_district_et);
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
    public void onMapClick(LatLng latLng) {
        GeoCoder geoCoder = GeoCoder.newInstance();
        geoCoder.setOnGetGeoCodeResultListener(new OnGetGeoCoderResultListener() {
            @Override
            public void onGetGeoCodeResult(GeoCodeResult geoCodeResult) {
                System.out.println("1111111111111");
            }

            @Override
            public void onGetReverseGeoCodeResult(ReverseGeoCodeResult reverseGeoCodeResult) {
                if (reverseGeoCodeResult == null
                        || reverseGeoCodeResult.error != SearchResult.ERRORNO.NO_ERROR) {
                    System.out.println();
                    // 没有检测到结果
                } else {
                    System.out.println(reverseGeoCodeResult.getAddress());
                }

            }
        });
        geoCoder.reverseGeoCode(new ReverseGeoCodeOption().location(latLng));
        System.out.println("latitude = " + latLng.latitude);
        System.out.println("longitude = " + latLng.longitude);
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
            System.out.println("point = " + point);
            final PoiSearch mPoiSearch = PoiSearch.newInstance();
            mPoiSearch.setOnGetPoiSearchResultListener(new OnGetPoiSearchResultListener() {
                public void onGetPoiResult(PoiResult result) {

                    //获取POI检索结果
                }

                public void onGetPoiDetailResult(PoiDetailResult result) {
                    MyLocationData locData = new MyLocationData.Builder()
                            // 此处设置开发者获取到的方向信息，顺时针0-360
                            .direction(100).latitude(result.getLocation().latitude)
                            .longitude(result.getLocation().longitude).build();
                    baiduMap.setMyLocationData(locData);
                    //获取Place详情页检索结果
                    mPoiSearch.destroy();
                }

                @Override
                public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

                }
            });
            mPoiSearch.searchNearby(new PoiNearbySearchOption().keyword(point));
        }
    }
}
