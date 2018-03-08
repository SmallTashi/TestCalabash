package com.tashi.testcalabash.activity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tashi.testcalabash.Date.Personal;
import com.tashi.testcalabash.Fragment.PersonalFragment;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.JSONmanager;
import com.tashi.testcalabash.tools.MyApplication;
import com.tashi.testcalabash.tools.Parameter;

import org.json.JSONException;

/**
 * Created by SmartTahi on 2018/2/21.
 *
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back;
    private EditText phoneNumber;
    private EditText password;
    private EditText verification;
    private TextView get;
    private Button next;
    private String phone;
    private String pwd;
    private String verif;


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        LinearLayout linearLayout1 = findViewById(R.id.linear_layout);
        linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        findViews();
        back.setClickable(true);
        this.phone = phoneNumber.getText().toString();
        this.pwd = password.getText().toString();
        this.verif = verification.getText().toString();
    }
    public void findViews() {
        this.password = findViewById(R.id.register_ac_2);
        this.phoneNumber = findViewById(R.id.register_ac_1);
        this.verification = findViewById(R.id.register_ac_3);
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
            if (BaseActivity.isPhoneLegal(phone)) {
                String p = null;
                String param = Api.VERIFICATION_head + phone + Api.VERIFICATION_foot;
                HttpUtils.sentHttpRequest(p, param, new HttpUtils.Callback() {
                    @Override
                    public void onSuccess(HttpUtils.Response response) {
                        if (response.getState().equals("204001")) {
                            Toast.makeText(MyApplication.getThisContext(), "验证码已发送，请小主注意查收...", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFiled(Exception e) {
                        Toast.makeText(MyApplication.getThisContext(), e.toString(), Toast.LENGTH_LONG).show();
                    }
                });
            } else {
                Toast toast = new Toast(MyApplication.getThisContext());
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.setText("小主您的手机号码不符合规定哟...");
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        } else if (next == v) {
            if(verif == null){
                Toast.makeText(MyApplication.getThisContext(),"请小主输入验证码...",Toast.LENGTH_LONG).show();
            }else {

                HttpUtils.sentHttpRequest(Parameter.Register(phone,pwd, verif), Api.REGISTER, new HttpUtils.Callback() {
                    @Override
                    public void onSuccess(HttpUtils.Response response) throws JSONException {
                        if(response.getState().equals("201001")){
                            Personal user = JSONmanager.newUser(response.getStringDate());
                            user.setUsername("尼古拉斯"+verif+"世");
                            user.setRank(0);
                            Bundle args = new Bundle();
                            args.putParcelable("newUser",user);
                            PersonalFragment mine = new PersonalFragment();
                            mine.setArguments(args);
                        }
                    }

                    @Override
                    public void onFiled(Exception e) {

                    }
                });
            }
        }
    }
}
