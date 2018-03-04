package com.tashi.testcalabash.Activity;


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

import com.tashi.testcalabash.R;

import static android.widget.Toast.LENGTH_LONG;

/**
 * Created by SmartTahi on 2018/2/21.
 *
 */

public class RegisterActivity extends BaseActivity {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        LinearLayout linearLayout1 = findViewById(R.id.linear_layout);
        linearLayout1.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        ImageView imageView = findViewById(R.id.back_register);
        imageView.setClickable(true);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(back);
                finish();
            }
        });
        EditText num = findViewById(R.id.register_ac_1);
        String phone = num.getText().toString();
        EditText mm = findViewById(R.id.register_ac_2);
        String pwd = mm.getText().toString();
        EditText yz = findViewById(R.id.register_ac_3);
        String verif = yz.getText().toString();
        TextView get = findViewById(R.id.register_get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this, "哎呀，人家正在努力写嘛，憋急", LENGTH_LONG).show();
            }
        });
        Button over = findViewById(R.id.button_next);
        over.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterActivity.this,"哎呀，人家正在努力写嘛，憋急", LENGTH_LONG).show();
            }
        });
    }


}
