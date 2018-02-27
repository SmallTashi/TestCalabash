package com.tashi.testcalabash;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
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

    }


}
