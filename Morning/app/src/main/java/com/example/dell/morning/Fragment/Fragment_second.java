package com.example.dell.morning.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;
import com.example.dell.morning.MyApplication;
import com.example.dell.morning.R;

/**
 * Created by dell on 2018/1/25.
 */

public class Fragment_second extends Fragment {
    private MapView mMapView = null;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.main_fragment_second,container,false)      ;
        mMapView=view.findViewById(R.id.mapwei);
        initView();
        return view;

    }

    private void initView() {
        LatLng ll=new LatLng(36.670,117.053);
        BaiduMap baidumap=mMapView.getMap();
        MapStatusUpdate update=MapStatusUpdateFactory.newLatLng(ll);
        baidumap.animateMapStatus(update);
        update= MapStatusUpdateFactory.zoomTo(19f);
        baidumap.animateMapStatus(update);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    public void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }
}

