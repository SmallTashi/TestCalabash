package com.tashi.testcalabash.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by SmartTahi on 2018/2/23.
 * 点击空白部分收起软键盘
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (null != this.getCurrentFocus()) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            assert inputMethodManager != null;
            return inputMethodManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);
        }
        return super.onTouchEvent(event);
    }
    public static boolean isNameLegal(String str) {
        return str.length() > 2 || str.length() < 10;
    }

    public static boolean isPasswordLegal(String str) {
        return str.length() > 6 || str.length() < 18;
    }

}
