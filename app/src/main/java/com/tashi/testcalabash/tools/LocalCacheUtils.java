package com.tashi.testcalabash.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by SmartTahi on 2018/3/10.
 * 本地保存
 */

class LocalCacheUtils {
    private static final String CACHE_PATH= Environment.getExternalStorageDirectory().getAbsolutePath()+"/image";
    void setBitmapToLocal(String url, Bitmap bitmap) {
        String fileName;
        try{
            fileName = url;
            File file = new File(CACHE_PATH,fileName);

            File parentFile = file.getParentFile();
            if(!parentFile.exists()){
                parentFile.mkdirs();
            }
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,new FileOutputStream(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    Bitmap getBitmapFromLocal(String url) {
        String fileName;//把图片的url当做文件名
        try {
            fileName = url;
            File file = new File(CACHE_PATH, fileName);
            return BitmapFactory.decodeStream(new FileInputStream(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
