package com.tashi.testcalabash;

import android.annotation.SuppressLint;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.tashi.testcalabash.Fragment.FindFragment;
import com.tashi.testcalabash.Fragment.PersonalFragmenr;
import com.tashi.testcalabash.Fragment.RecommendFragment;
import com.tashi.testcalabash.Fragment.ThemeFragment;

/*
*
* Created by SmartTashi .
*2018/2/24:
* //TODO 优化：使用fragment适配大屏幕
* //TODO 以可滑动的TabLayout代替横向的ListView
* */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)  //自动修复提示补上的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        replaceFragment(new ThemeFragment());

        final TabItem theme = findViewById(R.id.theme_item);
        theme.setOnClickListener(this);
        final TabItem recommend = findViewById(R.id.recommend_item);
        recommend.setOnClickListener(this); //TODO:此处有BUG,解决办法（try）：创建一个事件监听类(不能再主线程？？)继承OnClickListener
        final TabItem find = findViewById(R.id.find_item);
        theme.setOnClickListener(this);
        final TabItem personal = findViewById(R.id.personal_item);
        theme.setOnClickListener(this);
    }

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.find_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.theme_item:
                replaceFragment(new ThemeFragment());
                break;
            case R.id.recommend_item:
                replaceFragment(new RecommendFragment());
                break;
            case R.id.personal_item:
                replaceFragment(new PersonalFragmenr());
                break;
            case R.id.find_item:
                replaceFragment(new FindFragment());
                break;
        }
    }
}
