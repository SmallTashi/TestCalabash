package com.tashi.testcalabash.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tashi.testcalabash.R;

/**
 * Created by SmartTahi on 2018/2/24.
 * 主题世界的Fragment
 */

public class ThemeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.theme_world_fragment,container,false);
    }
}
