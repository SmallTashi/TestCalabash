package com.tashi.testcalabash.activity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.Fragment.PersonalFragment;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.JSONmanager;
import com.tashi.testcalabash.tools.PackParameter;
import com.tashi.testcalabash.tools.ShowToast;

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
    public static String username = "";
    public static String pwd = "";
    public static int mState;
    private int INTERNET_REQUEST_CODE = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            //没有 CALL_PHONE 权限
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.CALL_PHONE)){
                new AlertDialog.Builder(this)
                        .setTitle("申请网络权限")
                        .setMessage("是否同意联网请求，以获得精彩内容")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ActivityCompat.requestPermissions(LoginActivity.this,new String[]{Manifest.permission.INTERNET},INTERNET_REQUEST_CODE);
                            }
                        }).show();
            }else{
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.INTERNET},INTERNET_REQUEST_CODE);

            }

        } else {
            findViews();
            username = Username.getText().toString();
            pwd = password.getText().toString();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:

        }
    }

    public void checkLoginMessage(String name, String pwd) {
        HttpUtils.sentHttpRequest(PackParameter.Login(name, pwd),Api.BH_LOGIN, new HttpUtils.Callback() {
            @Override
            public void onSuccess(HttpUtils.Response response) throws JSONException {
                mState = response.getState();
                if (mState == 200) {
                    User user = JSONmanager.getUser(response.getDate());
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("user", user);
                    PersonalFragment fragment = new PersonalFragment();
                    fragment.setArguments(bundle);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    ShowToast.addToast("哎呀糟糕，登录失败了，请小主检查用户名或密码是否输入正确...",false);
                }
            }
            @Override
            public void onFiled(Exception e) {
                ShowToast.addToast(e.toString(),true);
                Log.w("tag",e);
            }
        });
    }

    public void findViews() {
        this.login = findViewById(R.id.login);
        this.password = findViewById(R.id.edit_password);
        this.Username = findViewById(R.id.edit_user_name_login);
        this.register = findViewById(R.id.register_text);
        this.easyRegister = findViewById(R.id.forget_password);
        this.otherWay = findViewById(R.id.other_way);
        this.logo = findViewById(R.id.logo);
        register.setClickable(true);
        easyRegister.setClickable(true);
        login.setOnClickListener(this);
        otherWay.setOnClickListener(this);
        register.setOnClickListener(this);
        easyRegister.setOnClickListener(this);
        logo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == register) {
            Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(register);
            finish();
        } else if (v == easyRegister) {
            Intent reset = new Intent(LoginActivity.this, P_registerActivity.class);
            startActivity(reset);
            finish();
        } else if (v == login) {
            if (BaseActivity.isNameLegal(username)&&BaseActivity.isPasswordLegal(pwd)) {
                checkLoginMessage(username, pwd);
            }
            else {
                ShowToast.addToast("嘤嘤嘤,输入错误,请小主重新输入",false);
            }
        } else if (v == otherWay) {
            ShowToast.addToast("别点我，别点我，别点我,别点我，别点我，别点我，别点我，别点我，别点我",true);
        }
        else{
            ShowToast.addToast("瞎点啥呐，讨厌...",true);
        }
    }
}
