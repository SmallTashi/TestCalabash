package com.tashi.testcalabash.tools;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by SmartTahi on 2018/3/10.
 * 网络缓存
 */

class NetCacheUtils {
    private LocalCacheUtils mLocalCacheUtils;
   public NetCacheUtils (){}

    NetCacheUtils(LocalCacheUtils localCacheUtils) {
        mLocalCacheUtils = localCacheUtils;
    }
    //从网上下载图片

     void getBitmapFromNet(ImageView ivPic, String url) {
        new BitmapTask().execute(ivPic, url);//启动AsyncTask
    }

    /**
     * AsyncTask抽象类：封装好的轻量级异步类
     * 两个线程池：
     * SerialExecutor和THREAD_POOL_EXECUTOR
     * 以及一个：
     * Handler(InternalHandler)
     *
     * public abstract class AsyncTask<Params, Progress, Result>
     * 1.参数类型
     * 2.下载进度
     * 3.异步任务执行完后返回的结果类型
     * 如果AsyncTask确定不需要传递具体参数，那么这三个泛型参数可以用Void来代替。
     * */
    @SuppressLint("StaticFieldLeak")
    class BitmapTask extends AsyncTask<Object, Void, Bitmap> {
        private ImageView ivPic;
        private String url;

        /**
         * 这个方法中的所有代码都会在子线程中运行，我们应该在这里去处理所有的耗时任务。
         * 任务一旦完成就可以通过return语句来将任务的执行结果进行返回，
         * 如果AsyncTask的第三个泛型参数指定的是Void，就可以不返回任务执行结果。注意，在这个方法中是不可以进行UI操作的，如果需要更新UI元素，比如说反馈当前任务的执行进度，可以调用publishProgress(Progress...)方法来完成。
        */
        @Override
        protected Bitmap doInBackground(Object[] params) {
            ivPic = (ImageView) params[0];
            url = (String) params[1];
            return downLoadBitmap(url);
        }
        /**当在后台任务中调用了publishProgress(Progress...)方法后，这个方法就很快会被调用，方法中携带的参数就是在后台任务中传递过来的。
         * 在这个方法中可以对UI进行操作，在主线程中进行，利用参数中的数值就可以对界面元素进行相应的更新。
         */
        @Override
        protected void onProgressUpdate(Void[] values) {
            super.onProgressUpdate(values);
        }

        /**
         *这个方法会在后台任务开始执行之间调用，在主线程执行。
         * 用于进行一些界面上的初始化操作，比如显示一个进度条对话框等。
         */
        @Override
        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                ivPic.setImageBitmap(result);
                addToast("从网络缓存图片啦.....",true);
                //从网络获取图片后,保存至本地缓存
                mLocalCacheUtils.setBitmapToLocal(url, result);
            }
        }
    }
    private void addToast(String s, boolean Short){
        if(Short){
            Toast.makeText(MyApplication.getThisContext(),s,Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MyApplication.getThisContext(),s,Toast.LENGTH_LONG).show();
        }
    }

    private Bitmap downLoadBitmap(String url) {
        HttpURLConnection conn = null;
        try {
            URL adress = new URL(url);
            conn = (HttpURLConnection) adress.openConnection();
            conn.setConnectTimeout(10*1000);
            conn.setReadTimeout(5*1000);
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                //图片压缩
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 2;//宽高压缩为原来的1/2
                options.inPreferredConfig = Bitmap.Config.ARGB_4444;
                return BitmapFactory.decodeStream(conn.getInputStream(), null, options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(conn != null)
            conn.disconnect();
        }
        return null;
    }
}

