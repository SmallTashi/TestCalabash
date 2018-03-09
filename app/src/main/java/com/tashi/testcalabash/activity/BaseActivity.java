package com.tashi.testcalabash.activity;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;

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

    public static boolean isPhoneNumberLegal(String str) {
        char[] number;
        boolean i = false;
        number = str.toCharArray();
        char[] check = new char[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        if (number.length == check.length) {
            if (number[0] == 1) {
                i = true;
            }
        } else {
            i =  false;
        }
        return i;
    }
}
