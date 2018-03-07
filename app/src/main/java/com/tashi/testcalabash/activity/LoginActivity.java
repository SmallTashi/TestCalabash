package com.tashi.testcalabash.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.Parameter;

/**
 * Created by SmartTashi on 2018/2/21.
 * 2018/2/23:
 * 添加BaseActivity（覆写onTouchEvent方法：在其中判断焦点。。。什么什么的
 * 返回不同的Flag） //大概是这样的吧
 * 使其他所有的Activity继承BaseActivity即可实现点击空白区域，隐藏软键盘。
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener{
    private EditText phoneNumber;
    private EditText password;
    private Button login;
    private TextView resetPassword;
    private TextView register;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        findViews();
        register.setClickable(true);
        resetPassword.setClickable(true);
        String number = phoneNumber.getText().toString();
        String pwd = password.getText().toString();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 开启网络请求，核对用户身份信息并保持登陆状态
            }
        });
    }
    public void checkLoginMessge(String phone,String pwd){
        String param;
        param=Parameter.Login(phone,pwd);
        String api = Api.LOGIN;
        HttpUtils.sentHttpRequest(param, api, new HttpUtils.Callback() {
            @Override
            public void onSuccess(HttpUtils.Response response) {

            }

            @Override
            public void onFiled(Exception e) {

            }
        });

    }
    public void findViews(){
        this.login = findViewById(R.id.login);
        this.password = findViewById(R.id.edit_password);
        this.phoneNumber = findViewById(R.id.edit_phonenum);
        this.register = findViewById(R.id.register_text);
        this.resetPassword =findViewById(R.id.forget_password);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_text:
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
                finish();
                break;
            case R.id.forget_password:
                Intent reset = new Intent(LoginActivity.this, ResetPwdActivity.class);
                startActivity(reset);
                finish();
                break;
            case R.id.other_way:
                Toast.makeText(this,"别点我，别点我，别点我，别点我，别点我，别点我",Toast.LENGTH_SHORT).show();


        }
    }
}
