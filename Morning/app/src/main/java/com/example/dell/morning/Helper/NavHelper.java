package com.example.dell.morning.Helper;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.SparseArray;

/**
 * 解決对fragment的调度与重用问题
 * Created by dell on 2018/1/25.
 */

public class NavHelper <T>{
    //Tab集合
    private  final SparseArray<Tab<T>>tabs=new SparseArray();
    private final FragmentManager fragmentManager;
    private final int containerId;
    private  final Context context;
    private OnTabChangeListener<T>listener;
    //当前的tab
    private  Tab<T>currentTab;

    public NavHelper(FragmentManager fragmentManager, int containerId, Context context, OnTabChangeListener<T> listener) {
        this.fragmentManager = fragmentManager;
        this.containerId = containerId;
        this.context = context;
        this.listener = listener;
    }

    /**
     *
     * 添加tab
     */
    public NavHelper<T> add(int meunId,Tab<T>tab){
        tabs.put(meunId, tab);
        return this;
    }

    /**
     * h或取当前的TAb
     * @return
     */
    public Tab<T >getCurrentTab(){
        return currentTab;
    }

    /*
    * 执行点击菜单操作后的调度
    * */
    public boolean performclick(int menuItem){
        Tab<T>tab=tabs.get(menuItem);
        if(tab!=null){
            doSelect(tab);
            return true;
        }
        return false;
    }

    /**
     * 进行真是tab选择操作
     * @param tab
     */
    private void doSelect(Tab<T> tab){
        Tab<T>oldTab=null;
        if(currentTab!=null){
            oldTab=currentTab;
            //点击当前Tab不做处理
            if(oldTab==tab){
                return;
            }
        }
        currentTab=tab;
        doTabChange(currentTab,oldTab);
    }

    /**
     * 进行tab切换，fragment切换
     * @param newTab
     */
    private void doTabChange(Tab<T>newTab,Tab<T> oldTab ){
        FragmentTransaction ft=fragmentManager.beginTransaction();
        if(oldTab!=null){
            if(oldTab.fragment!=null){
                ft.detach(oldTab.fragment);//缓存移除
            }
        }
        if(newTab!=null){
            if (newTab.fragment==null){
                //首次创建
                Fragment fragment=Fragment.instantiate(context,newTab.clx.getName());
                newTab.fragment=fragment;
                ft.add(containerId,fragment,newTab.clx.getName());
            }else{
                ft.attach(newTab.fragment);
            }
        }
        ft.commit();
        notifyTabSelect(newTab,oldTab);
    }
    private void notifyTabSelect(Tab<T>newTab,Tab<T> oldTab){
        if(listener!=null){
            listener.OnTabChanged(newTab,oldTab);
        }
    }
    /*]

       切换后的回调接口

     */
    public interface  OnTabChangeListener<T>{
        void OnTabChanged(Tab<T>newTab ,Tab<T> oldTab);
    }

    /**
     * 封装Tab缓存fragent
     * @param <T>
     */


    public static class Tab<T>{
        public Class<?>clx;
        //额外的字段
        public T extra;
        //内部缓存的fragment
         Fragment fragment;

        public Tab(Class<?> clx, T extra) {
            this.clx = clx;
            this.extra = extra;
        }
    }
}
