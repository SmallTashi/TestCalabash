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
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.tashi.testcalabash.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SmartTahi on 2018/2/24.
 * 主题世界的Fragment
 */

public class ThemeFragment extends Fragment {
    WebView webview;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.theme_world_fragment,container,false);
    }

    @SuppressLint("SetJavaScriptEnabled")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        webview = view.findViewById(R.id.webView2);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);

        //支持缩放
        settings.setUseWideViewPort(true);//设定支持viewport
        settings.setLoadWithOverviewMode(true);
        settings.setBuiltInZoomControls(true);
        settings.setSupportZoom(true);//设定支持缩放
        //打开的网址
        webview.loadUrl("https://www.huluzc.com/explore");
    }
}
