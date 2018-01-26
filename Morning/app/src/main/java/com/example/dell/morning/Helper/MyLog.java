package com.example.dell.morning.Helper;

import android.util.Log;

/**
 * Created by dell on 2018/1/25.
 */

public class MyLog  {
   private static  boolean x=true;
  public static void log(String k,String e){
      if(x)
         Log.e(k,e);
  }
}
