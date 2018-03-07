package com.tashi.testcalabash.Activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.tashi.testcalabash.R;

/**
 * Created by SmartTashi on 2018/2/21.
 * 2018/2/23:
 * 添加BaseActivity（覆写onTouchEvent方法：在其中判断焦点。。。什么什么的
 * 返回不同的Flag） //大概是这样的吧
 * 使其他所有的Activity继承BaseActivity即可实现点击空白区域，隐藏软键盘。
 */
public class LoginActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        TextView register = findViewById(R.id.register_text);
        register.setClickable(true);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                finish();
            }
        });
        final TextView forget = findViewById(R.id.forget_password);
        forget.setClickable(true);
        forget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reset = new Intent(LoginActivity.this, ResetPwdActivity.class);
                startActivity(reset);
                finish();
            }
        });
        EditText num = findViewById(R.id.edit_phonenum);
        String number = num.getText().toString();
        EditText pa = findViewById(R.id.edit_password);
        String pwd = pa.getText().toString();
        //TODO 开启网络请求，核对用户身份信息并保持登陆状态
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(login);
                finish();
            }
        });
    }
}
