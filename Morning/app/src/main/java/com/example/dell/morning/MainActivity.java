package com.example.dell.morning;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;

import com.baidu.mapapi.SDKInitializer;
import com.example.dell.morning.Fragment.First.Fragment_first;
import com.example.dell.morning.Fragment.First.HomeAdapter;
import com.example.dell.morning.Fragment.Fragment_second;
import com.example.dell.morning.Fragment.Fragment_third;
import com.example.dell.morning.Helper.NavHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.Home)
    ImageButton home;
    @BindView(R.id.Person)
    ImageButton person;
    @BindView(R.id.Map)
    ImageButton map;




    private NavHelper<Integer> navHelper;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(MyApplication.getContext());
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT)
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //初始化工具类
        navHelper =new NavHelper(getSupportFragmentManager(), R.id.lay_content,this , new NavHelper.OnTabChangeListener() {
            @Override
            public void OnTabChanged(NavHelper.Tab newTab, NavHelper.Tab oldTab) {

            }
        });
        navHelper
                .add(1,new NavHelper.Tab(Fragment_first.class,1))
                .add(2,new NavHelper.Tab(Fragment_second.class,2))
                .add(3,new NavHelper.Tab(Fragment_third.class,3));
        onNavigationItemSelected(1);



    }


    @OnClick({R.id.Home,R.id.Map,R.id.Person})
public void onItemclick(View view) {
    switch (view.getId()) {
        case R.id.Home:

            onNavigationItemSelected(1);
            break;
        case R.id.Map:
            onNavigationItemSelected(2);
            break;
        case R.id.Person:
            onNavigationItemSelected(3);
            break;
    }
}


    public boolean onNavigationItemSelected(int MenuItem){
        //
        return navHelper.performclick(MenuItem);
    }


}
