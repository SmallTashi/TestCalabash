package com.tashi.testcalabash.activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
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
import com.tashi.testcalabash.tools.JSONmanager;
import com.tashi.testcalabash.tools.MyApplication;
import com.tashi.testcalabash.tools.PackParameter;


import org.json.JSONException;

/**
 * Created by SmartTahi on 2018/2/21.
 *
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private EditText phoneNumber;
    private EditText username;
    private EditText password;
    private EditText verification;
    private TextView get;
    private TextView pass;
    private Button next;
    private String name;
    private String pwd;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        LinearLayout linearLayout1 = findViewById(R.id.linear_layout);
        linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        findViews();
        next.setOnClickListener(this);
        get.setOnClickListener(this);
        back.setClickable(true);
        back.setOnClickListener(this);
        back.setClickable(true);
        pass.setOnClickListener(this);
    }
    public void findViews() {
        this.username = findViewById(R.id.register_ac_0);
        this.password = findViewById(R.id.register_ac_2);
        this.phoneNumber = findViewById(R.id.register_ac_1);
        this.verification = findViewById(R.id.register_ac_3);
        this.pass = findViewById(R.id.pass);
        this.get = findViewById(R.id.register_get);
        this.back = findViewById(R.id.back_register);
        this.next = findViewById(R.id.button_next);
    }

    @Override
    public void onClick(View v) {
        if (v == back) {
            Intent back = new Intent(RegisterActivity.this, LoginActivity.class);
            startActivity(back);
            finish();
        } else if (v == get) {
            this.name = username.getText().toString();
            this.pwd = password.getText().toString();
            String phone = phoneNumber.getText().toString();
            if (name != null) {
                String p = null;
                String param = Api.VERIFICATION_head + phone + Api.VERIFICATION_foot;
                HttpUtils.sentHttpsRequest(p, param, new HttpUtils.Callback() {
                    @Override
                    public void onSuccess(HttpUtils.Response response) {
                        String s = "0";
                        if (response.emptyData(s)) {
                            addToast("验证码已发送，请小主注意查收...",true);
                        }
                    }
                    @Override
                    public void onFiled(Exception e) {
                        addToast(e.toString(),false);
                    }
                });
            } else {addToast("小主您的手机号码不符合规定哟...",false);
            }
        }
        else if (next == v) {
            String verif = verification.getText().toString();
            HttpUtils.sentHttpRequest(PackParameter.BHRegisterLogin(name,pwd, verif), Api.BH_REGISTER, new HttpUtils.Callback() {
                @Override
                public void onSuccess(HttpUtils.Response response) throws JSONException {
                    User user = response.getNewuser(response.getDate());
                    user.setPassword(pwd);
                    Bundle args = new Bundle();
                    args.putParcelable("newUser",user);
                    PersonalFragment mine = new PersonalFragment();
                    mine.setArguments(args);
                    Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                @Override
                public void onFiled(Exception e) {
                    addToast(e.toString(),false);
                }
            });
            if (pass == v) {
                Intent intent = new Intent(this, P_registerActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
    public void addToast(String s, boolean Short){
        if(Short){
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this,s,Toast.LENGTH_LONG).show();
        }
    }
}
