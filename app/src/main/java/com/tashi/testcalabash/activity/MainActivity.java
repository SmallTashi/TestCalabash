package com.tashi.testcalabash.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tashi.testcalabash.Fragment.FindFragment;
import com.tashi.testcalabash.Fragment.PersonalFragment;
import com.tashi.testcalabash.Fragment.RecommendFragment;
import com.tashi.testcalabash.Fragment.ThemeFragment;
import com.tashi.testcalabash.R;

import java.util.HashMap;

/*
*
* Created by SmartTashi .
*2018/2/24:

* */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public FindFragment mFindFragment = new FindFragment();
    public PersonalFragment mPersonalFragment = new PersonalFragment();
    public RecommendFragment mRecommendFragment = new RecommendFragment();
    public ThemeFragment mThemeFragment = new ThemeFragment();
    public HashMap<String, Integer> mIcon;
    public RelativeLayout theme;
    public ImageView theme1;
    public RelativeLayout recommend;
    public RelativeLayout find;
    public RelativeLayout personal;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)  //自动修复提示补上的
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("MainActivity", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIcon();
        findViews();
        theme1.setImageDrawable(getResources().getDrawable(mIcon.get("0")));
        replaceFragment(mThemeFragment);
    }

    public void findViews() {
        theme = findViewById(R.id.theme_item);
        theme1 = findViewById(R.id.q);
        recommend = findViewById(R.id.recommend_item);
        find = findViewById(R.id.find_item);
        personal = findViewById(R.id.personal_item);
        theme.setOnClickListener(this);
        recommend.setOnClickListener(this);
        find.setOnClickListener(this);
        personal.setOnClickListener(this);
    }

    private void replaceFragment(Fragment fragment) {
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.find_fragment, fragment);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {

        ImageView theme = findViewById(R.id.q);
        ImageView find = findViewById(R.id.as);
        ImageView recommend = findViewById(R.id.e);
        ImageView personal = findViewById(R.id.v);
        switch (v.getId()) {
            case R.id.theme_item:
                theme.setImageDrawable(getResources().getDrawable(mIcon.get("0")));
                recommend.setImageDrawable(getResources().getDrawable(mIcon.get("3")));
                find.setImageDrawable(getResources().getDrawable(mIcon.get("5")));
                personal.setImageDrawable(getResources().getDrawable(mIcon.get("7")));
                replaceFragment(mThemeFragment);
                break;
            case R.id.recommend_item:
                theme.setImageDrawable(getResources().getDrawable(mIcon.get("1")));
                recommend.setImageDrawable(getResources().getDrawable(mIcon.get("2")));
                find.setImageDrawable(getResources().getDrawable(mIcon.get("5")));
                personal.setImageDrawable(getResources().getDrawable(mIcon.get("7")));
                replaceFragment(mRecommendFragment);
                break;
            case R.id.personal_item:
                theme.setImageDrawable(getResources().getDrawable(mIcon.get("1")));
                recommend.setImageDrawable(getResources().getDrawable(mIcon.get("3")));
                find.setImageDrawable(getResources().getDrawable(mIcon.get("5")));
                personal.setImageDrawable(getResources().getDrawable(mIcon.get("6")));
                replaceFragment(mPersonalFragment);
                break;
            case R.id.find_item:
                theme.setImageDrawable(getResources().getDrawable(mIcon.get("1")));
                recommend.setImageDrawable(getResources().getDrawable(mIcon.get("3")));
                find.setImageDrawable(getResources().getDrawable(mIcon.get("4")));
                personal.setImageDrawable(getResources().getDrawable(mIcon.get("7")));
                replaceFragment(mFindFragment);
                break;
        }
    }

    void initIcon() {
        this.mIcon = new HashMap<>();
        mIcon.put("0", R.mipmap.theme_sel);
        mIcon.put("1", R.mipmap.theme_unsel);
        mIcon.put("2", R.mipmap.recommend_sel);
        mIcon.put("3", R.mipmap.recommed_unsel);
        mIcon.put("4", R.mipmap.follow_sel);
        mIcon.put("5", R.mipmap.follow_unsel);
        mIcon.put("6", R.mipmap.mine_sel);
        mIcon.put("7", R.mipmap.mine_unsel);
    }

}