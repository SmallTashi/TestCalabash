package com.tashi.testcalabash.Fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.activity.LoginActivity;
import com.tashi.testcalabash.activity.MainActivity;
import com.tashi.testcalabash.activity.P_registerActivity;
import com.tashi.testcalabash.activity.RegisterActivity;
import com.tashi.testcalabash.tools.Api;
import com.tashi.testcalabash.tools.HttpUtils;
import com.tashi.testcalabash.tools.Https;
import com.tashi.testcalabash.tools.MyApplication;
import com.tashi.testcalabash.tools.PackParameter;

import org.json.JSONException;

import java.util.ArrayList;

public class FindFragment extends Fragment implements View.OnClickListener {
    private EditText phoneNumber;
    private EditText username;
    private EditText password;
    private TextView get;

    private ArrayList<Integer> mViewPagerImage;
    private static Handler HttpHandler = new Handler();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.register_activity, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayout linearLayout1 = view.findViewById(R.id.linear_layout);
        linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        this.username = view.findViewById(R.id.register_ac_0);
        this.password = view.findViewById(R.id.register_ac_2);
        this.phoneNumber = view.findViewById(R.id.register_ac_1);
        EditText verification = view.findViewById(R.id.register_ac_3);
        TextView pass = view.findViewById(R.id.pass);
        this.get = view.findViewById(R.id.register_get);
        Button next = view.findViewById(R.id.button_next);
        next.setOnClickListener(this);
        get.setOnClickListener(this);
        pass.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
       if (v == get) {
           String name = username.getText().toString();
           String pwd = password.getText().toString();
            String phone = phoneNumber.getText().toString();
            if (name != null) {
                String p = null;
                String param = Api.VERIFICATION_head + phone + Api.VERIFICATION_foot;
                Https.GetVerif(p,param);
            } else {addToast("小主您的手机号码不符合规定哟...",false);
            }
        }
    }
    public void addToast(String s, boolean Short){
        if(Short){
            Toast.makeText(MyApplication.getThisContext(),s,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MyApplication.getThisContext(),s,Toast.LENGTH_LONG).show();
        }
    }
}
