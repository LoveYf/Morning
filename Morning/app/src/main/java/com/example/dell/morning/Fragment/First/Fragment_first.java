package com.example.dell.morning.Fragment.First;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.morning.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dell on 2018/1/25.
 */

public class Fragment_first  extends Fragment{


    @BindView(R.id.REC)
    RecyclerView recyclerview;
    private HomeAdapter adapter;
    private ArrayList<String> data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view =inflater.inflate(R.layout.main_fragment_first,container,false)  ;
        ButterKnife.bind(this,view);
        initData();
        initView();

        return view;
    }

    private void initData() {
        data=new ArrayList<>();
        data.add("初次领养喵喵应该知道的那些事儿");
        data.add("初次领养喵喵应该知道的那些事儿");
        data.add("初次领养喵喵应该知道的那些事儿");
        data.add("初次领养喵喵应该知道的那些事儿");
        data.add("初次领养喵喵应该知道的那些事儿");
    }

    private void initView() {


        adapter=new HomeAdapter(getActivity(),data);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(adapter);
        recyclerview.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
}
