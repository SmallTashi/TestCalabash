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
import com.tashi.testcalabash.tools.MyApplication;
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

    private TextView resetPassword;
    private TextView register;

    private static String phone="";
    private static String pwd="";
    private static int mState ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        findViews();
        register.setClickable(true);
        resetPassword.setClickable(true);
        phone = phoneNumber.getText().toString();
        pwd= password.getText().toString();
    }

    public void checkLoginMessage(String phone, String pwd){
        String param;
        param=Parameter.Login(phone,pwd);
        String api = Api.LOGIN;
        HttpUtils.sentHttpRequest(param, api, new HttpUtils.Callback() {
            @Override
            public void onSuccess(HttpUtils.Response response) {
                //TODO 补充判断逻辑
                    mState = Integer.getInteger(response.getState());
                    if(mState == 200){

                    }
            }
            @Override
            public void onFiled(Exception e) {
                Toast.makeText(MyApplication.getThisContext(),e.toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
    public void findViews(){

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
            case R.id.login:
                //TODO 开启网络请求，核对用户身份信息并保持登陆状态
                checkLoginMessage(phone,pwd);
                break;
            case R.id.other_way:
                Toast.makeText(this,"别点我，别点我，别点我，别点我，别点我，别点我",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
