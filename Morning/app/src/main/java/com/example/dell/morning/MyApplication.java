package com.example.dell.morning;

import android.app.Application;
import android.content.Context;

/**
 * Created by dell on 2018/1/26.
 */

public class MyApplication extends Application {
    private static Context context;
    @Override
    public void onCreate(){
        context=getApplicationContext();
    }
    public static  Context getContext(){
        return  context;
    }
}
