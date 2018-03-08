package com.tashi.testcalabash.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

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
    //copy 的
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
