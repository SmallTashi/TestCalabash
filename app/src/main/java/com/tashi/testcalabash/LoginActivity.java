package com.tashi.testcalabash;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by SmartTashi on 2018/2/21.
 *2018/2/23:
 * 添加BaseActivity（覆写onTouchEvent方法：在其中判断焦点。。。什么什么的
 *                  返回不同的Flag） //大概是这样的吧
 * 使其他所有的Activity继承BaseActivity即可实现点击空白区域，隐藏软键盘。
 * 建议：注册界面使用WebView（后期实现）
 */

public class LoginActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
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
//                Intent intent=new Intent(loginActivity.this,MainActivity.class);
//                intent.getAction();
                Toast forgetPassword = Toast.makeText(getApplicationContext(), "你忘记了密码，我能怎么办嘛...", Toast.LENGTH_LONG);
                forgetPassword.show();
            }

        });
        Button login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(login);
                finish();
            }
        });
    }
}
