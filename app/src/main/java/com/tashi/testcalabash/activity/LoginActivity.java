package com.tashi.testcalabash.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.Fragment.PersonalFragment;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.PackParameter;

import org.json.JSONException;

/**
 * Created by SmartTashi on 2018/2/21.
 * 2018/2/23:
 * 添加BaseActivity（覆写onTouchEvent方法：在其中判断焦点。。。什么什么的
 * 返回不同的Flag） //大概是这样的吧
 * 使其他所有的Activity继承BaseActivity即可实现点击空白区域，隐藏软键盘。
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    public EditText Username;
    public EditText password;
    public LinearLayout otherWay;
    public TextView easyRegister;
    public TextView register;
    public Button login;
    public ImageView logo;
    public ImageView line;
    public static int mState;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        findViews();
        line.setOnClickListener(this);
        easyRegister.setOnClickListener(this);
        logo.setOnClickListener(this);
        easyRegister.setClickable(true);
        register.setClickable(true);
        login.setOnClickListener(this);
        otherWay.setOnClickListener(this);
        register.setOnClickListener(this);
    }

    public void checkLoginMessage(final String name, String pwd) {
        HttpUtils.sentHttpRequest(PackParameter.PassRegister(name, pwd),Api.BH_LOGIN, new HttpUtils.Callback() {
            @Override
            public void onSuccess(HttpUtils.Response response) throws JSONException {
                mState = response.getState();
                String s = "0";
                User user;
                if(response.emptyData(s)){
                    addToast(response.getInfo(),false);
                }
                else if(response.getState() !=200){
                    addToast("未知错误...",false);
                }else if(response.getState() != 200&&response.getInfo()!=null){
                    addToast("哎呀糟糕，登录失败了"+response.getInfo()+"，请小主重新输入...",false);
                }
                else {
                    user = response.getuser(response.getDate());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("user",user);
                    PersonalFragment personalFragment = new PersonalFragment();
                    personalFragment.setArguments(bundle);
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
            @Override
            public void onFiled(Exception e) {
                addToast(e.toString(),true);
                Log.w("tag",e);
            }
        });
    }
    public void findViews() {
        this.line = findViewById(R.id.line);
        this.login = findViewById(R.id.login);
        this.password = findViewById(R.id.edit_password);
        this.Username = findViewById(R.id.edit_user_name_login);
        this.register = findViewById(R.id.register_text);
        this.easyRegister = findViewById(R.id.forget_password);
        this.otherWay = findViewById(R.id.other_way);
        this.logo = findViewById(R.id.logo);

    }
    public void addToast(String s, boolean Short){
        if(Short){
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void onClick(View v) {
        if (v == register) {
            Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(register);
            finish();
        }else if (line==v){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else if (v == easyRegister) {
            Intent reset = new Intent(LoginActivity.this, P_registerActivity.class);
            startActivity(reset);
            finish();
        } else if (v == login) {
            String username;
            String pwd;
            username = Username.getText().toString();
            pwd = password.getText().toString();
            if (BaseActivity.isNameLegal(username)&&BaseActivity.isPasswordLegal(pwd)) {
                checkLoginMessage(username, pwd);
            }
            else {
                addToast("嘤嘤嘤,输入错误,请小主重新输入",false);
            }
        } else if (v == otherWay) {
            addToast("别点我，别点我，别点我,别点我，别点我，别点我，别点我，别点我，别点我",true);
        }
        else{
            addToast("瞎点啥呐，讨厌...",true);
        }
    }
}
