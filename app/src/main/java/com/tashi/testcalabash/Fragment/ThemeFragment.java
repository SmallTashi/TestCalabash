package com.tashi.testcalabash.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tashi.testcalabash.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SmartTahi on 2018/2/24.
 * 主题世界的Fragment
 */

public class ThemeFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.theme_world_fragment,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        @SuppressLint("HandlerLeak")
//        Handler mHandler = new Handler(){
//            public void handleMessage(Message message){
//                switch (message.what){
//                    case T
//                }
//            }
//        };
    }
}
class themeThread implements Runnable{
    List Test = new ArrayList();
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()){
            Message message = new Message();
            message.what=1;

        }
    }
}
