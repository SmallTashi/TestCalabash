package com.tashi.testcalabash.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.Fragment.PersonalFragment;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.PackParameter;

import org.json.JSONException;

public class P_registerActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_pwd);
        ImageView imageView  = findViewById(R.id.back_register);
        Button over= findViewById(R.id.easy_regist);
        over.setOnClickListener(this);
        imageView.setOnClickListener(this);

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
        EditText username= findViewById(R.id.reset_ac_1);
        EditText mm = findViewById(R.id.reset_ac_2);
        if(v.getId()==R.id.back_register){
            Intent back = new Intent(P_registerActivity.this, LoginActivity.class);
            startActivity(back);
            finish();
        }else if (v.getId()==R.id.easy_regist){
            String name = "";
            name=username.getText().toString();
            String password = "";
            password = mm.getText().toString();
            HttpUtils.sentHttpRequest(PackParameter.PassRegister(name, password), Api.BH_REGISTER, new HttpUtils.Callback() {
                @Override
                public void onSuccess(HttpUtils.Response response) throws JSONException {
                    if(response.getState()==200){
                        addToast("注册成功!",false);
                        User user;
                        String s = "0";
                        //TODO 添加等待Dialog
                        if(response.emptyData(s)){
                            addToast(response.getInfo(),false);
                        }else {
                            user = response.getuser(response.getDate());
                            Bundle bundle = new Bundle();
                            bundle.putParcelable("user",user);
                            PersonalFragment personalFragment = new PersonalFragment();
                            personalFragment.setArguments(bundle);
                            Intent intent = new Intent(P_registerActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }else if(response.getState()==400){
                        addToast(response.getInfo(),false);
                    }else {
                        addToast("未知错误...",true);
                    }
                }
                @Override
                public void onFiled(Exception e) {
                    addToast(e.toString(),false);
                }
            });
        }
    }
}
