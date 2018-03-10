package com.tashi.testcalabash.tools;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.tashi.testcalabash.Date.User;

/**
 * Created by SmartTahi on 2018/3/7.
 * 获得当前ActivityContext
 * 显示Toast提示信息
 */

public class MyApplication extends Application {
    @SuppressLint("StaticFieldLeak")
    private static Context thisContext;
    public static User user;

    @Override
    public void onCreate() {
        super.onCreate();
        thisContext = getApplicationContext();
    }
    public static Context getThisContext(){
        return thisContext;
    }

    public static void setUser(User user) {
        MyApplication.user = user;
    }

    public static User getUser() {
        return user;
    }
}
