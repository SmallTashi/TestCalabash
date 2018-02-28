package com.tashi.testcalabash;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tashi.testcalabash.Fragment.FindFragment;
import com.tashi.testcalabash.Fragment.PersonalFragmenr;
import com.tashi.testcalabash.Fragment.RecommendFragment;
import com.tashi.testcalabash.Fragment.ThemeFragment;

import java.util.ArrayList;

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
        RelativeLayout theme = findViewById(R.id.theme_item);
        theme.setOnClickListener(this);
        RelativeLayout recommend =findViewById(R.id.recommend_item);
        recommend.setOnClickListener(this);
        RelativeLayout find =findViewById(R.id.find_item);
        find.setOnClickListener(this);
        RelativeLayout personal =findViewById(R.id.personal_item);
        personal.setOnClickListener(this);
        replaceFragment(new ThemeFragment());
    }

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.find_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        //TODO : 图标更换太慢，改进方案——将八个icon初始化放到一个ArrayList里边（有序的）——优化速度？
        ImageView theme = findViewById(R.id.q);
        ImageView find = findViewById(R.id.as);
        ImageView recommend = findViewById(R.id.e);
        ImageView personal = findViewById(R.id.v);
        switch (v.getId()) {
            case R.id.theme_item:
                recommend.setImageDrawable(getResources().getDrawable(R.mipmap.recommed_unsel));
                theme.setImageDrawable(getResources().getDrawable(R.mipmap.theme_sel));
                find.setImageDrawable(getResources().getDrawable(R.mipmap.follow_unsel));
                personal.setImageDrawable(getResources().getDrawable(R.mipmap.mine_unsel));
                replaceFragment(new ThemeFragment());
                break;
            case R.id.recommend_item:
                recommend.setImageDrawable(getResources().getDrawable(R.mipmap.recommend_sel));
                theme.setImageDrawable(getResources().getDrawable(R.mipmap.theme_unsel));
                find.setImageDrawable(getResources().getDrawable(R.mipmap.follow_unsel));
                personal.setImageDrawable(getResources().getDrawable(R.mipmap.mine_unsel));
                replaceFragment(new RecommendFragment());
                break;
            case R.id.personal_item:
                recommend.setImageDrawable(getResources().getDrawable(R.mipmap.recommed_unsel));
                theme.setImageDrawable(getResources().getDrawable(R.mipmap.theme_unsel));
                find.setImageDrawable(getResources().getDrawable(R.mipmap.follow_unsel));
                personal.setImageDrawable(getResources().getDrawable(R.mipmap.mine_sel));
                replaceFragment(new PersonalFragmenr());
                break;
            case R.id.find_item:
                recommend.setImageDrawable(getResources().getDrawable(R.mipmap.recommed_unsel));
                theme.setImageDrawable(getResources().getDrawable(R.mipmap.theme_unsel));
                find.setImageDrawable(getResources().getDrawable(R.mipmap.follow_sel));
                personal.setImageDrawable(getResources().getDrawable(R.mipmap.mine_unsel));
                replaceFragment(new FindFragment());
                break;
        }
    }
}
//
//class mTabLayout extends TabLayout {
//    public mTabLayout(Context context) {
//        super(context);
//        mTabLayout.setOnTabSelectedListener(new TabLayoutOnTabSelectedListener() {
//            @Override
//            public void onTabSelected(Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(Tab tab) {
//
//            }
//        })
//    }
//
//
//}