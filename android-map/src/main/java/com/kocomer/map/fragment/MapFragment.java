package com.kocomer.map.fragment;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Text;
import com.baidu.mapapi.model.LatLng;
import com.kocomer.core.fragment.BaseFragment;
import com.kocomer.map.R;

import java.util.List;
import java.util.Map;

/**
 * Created by kocomer on 2017/9/22.
 */

public class MapFragment extends BaseFragment implements View.OnClickListener, BaiduMap.OnMapClickListener {
    private TextView searchTv;
    private MapView mapView;

    private LocationClient mLocationClient;
    private BaiduMap baiduMap;
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
                    .fromResource(R.drawable.icon_geo);
            MyLocationConfiguration config = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, bitmapDescriptor);
            baiduMap.setMyLocationConfiguration(config);

        }
    };

    @Override
    protected String setPageName() {
        return "Map";
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mLocationClient.stop();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        SDKInitializer.initialize(getActivity().getApplicationContext());
        mLocationClient = new LocationClient(getActivity().getApplicationContext());
        mLocationClient.registerLocationListener(myListener);
        mLocationClient.start();

        View view = inflater.inflate(R.layout.fragment_map, null);
        searchTv = (TextView) view.findViewById(R.id.fragment_map_search_tv);
        mapView = (MapView) view.findViewById(R.id.fragment_map_mv);


        baiduMap = mapView.getMap();
        baiduMap.setMyLocationEnabled(true);
        baiduMap.setOnMapClickListener(setOnMapClickListener());


        searchTv.setOnClickListener(this);
        return view;
    }

    public BaiduMap.OnMapClickListener setOnMapClickListener() {
        return this;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.fragment_map_search_tv) {

        }
    }

    @Override
    public void onMapClick(LatLng latLng) {
        System.out.println("latLng = " + latLng.latitude);
        System.out.println("latLng = " + latLng.longitude);
    }

    @Override
    public boolean onMapPoiClick(MapPoi mapPoi) {
        return false;
    }
}
