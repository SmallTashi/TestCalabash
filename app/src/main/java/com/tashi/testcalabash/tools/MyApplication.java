package com.tashi.testcalabash.tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

/**
 * Created by SmartTahi on 2018/3/7.
 * 获得当前ActivityContext
 * 显示Toast提示信息
 */

public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context thisContext;

    @Override
    public void onCreate() {
        super.onCreate();
        thisContext = getApplicationContext();
    }
    public static Context getThisContext(){
        return thisContext;
    }
}
