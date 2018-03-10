package com.tashi.testcalabash.tools;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by SmartTahi on 2018/3/7.
 * 图片的三级缓存
 */

public class MyBitmapUtils {
    private NetCacheUtils netCache;
    private LocalCacheUtils local;


    public MyBitmapUtils(){
        local = new LocalCacheUtils();
        netCache = new NetCacheUtils();
    }

    public void disPlay(ImageView ivpic,String url){
        Bitmap bitmap;
        bitmap = local.getBitmapFromLocal(url);
        if(bitmap !=null){
            ivpic.setImageBitmap(bitmap);
            Toast.makeText(MyApplication.getThisContext(),"从本地获取图片啦.....",Toast.LENGTH_SHORT).show();
            return;
        }
        //网络缓存
        netCache.getBitmapFromNet(ivpic,url);
    }
}

