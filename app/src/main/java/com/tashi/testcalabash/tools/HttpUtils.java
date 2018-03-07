package com.tashi.testcalabash.tools;

import android.net.Network;
import android.os.Handler;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import java.net.URL;


import javax.net.ssl.HttpsURLConnection;

/**
 * Created by SmartTashi on 2018/3/1.
 * 开启网络请求Post与Get
 */
public class HttpUtils {
    private HttpsURLConnection connection = null;
    private BufferedReader mReader = null;

    public void GetVerif(final String parameter, final String api, final Callback callback) {
        if(!Network)
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //"https://www.huluzc.com/calabash/code/phone?"+"&phone="+pa+"&category=0"
                    URL url = new URL(api);
                    connection = (HttpsURLConnection) url.openConnection();
                    connection.setReadTimeout(10 * 1000);
                    connection.setConnectTimeout(5 * 1000);
                    if (parameter == null) {
                        connection.setRequestMethod("GET");
                        connection.connect();
                    } else {
                        connection.setRequestMethod("POST");
                        connection.setDoInput(true);
                        connection.setDoOutput(true);
                        connection.setUseCaches(false);
                        connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                        connection.setRequestProperty("Content-Length", String.valueOf(parameter.length()));
                        OutputStream out = connection.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    if (connection.getResponseCode() == 200001 ||connection.getResponseCode()==204001) {
                        final byte[] temp = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.Success(new Response(temp));
                                //使用回调，返回请求得到的数据
                            }
                        });
                        //缓存图片资源
                    }else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.Filed(new Exception("加载失败"));
                            }
                        });
                    }


                    //TODO
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (mReader != null) {
                        try {
                            mReader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public static final byte[] ReadStream(InputStream in) {
        //建立通道对象
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //创建保存数据的字节数组
        byte[] temp = new byte[1024];
        //开始读取数据
        int len ;
        try {
            if (in != null) {
                while ((len = in.read(temp)) != -1) {
                    outputStream.write(temp, 0, len);
                    //数据由输入流写入字节数组，
                    //由字节数组写入到输出流中
                }
                in.close();
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }

    public interface Callback{
        void Success(Response response);

        void Filed (Exception e);
    }
    class Response{
        private int mCode;
        private String mInfo;
        private byte[] mDate;
        Response(byte[] response){
            String stringDate = new String(response);

        }
        }
}




    //获取分类标签下的文章
//    private String sentGET(final String param) throws Exception {
//        String ur = "https://www.huluzc.com/calabash/article?page=1&page_per=10&order_by=[\"praise_num\",\"published_time\"]&condition={\"tags\":[\"";
//        ur = ur + param + "\"]}";
//        try {
//            URL url = new URL(ur);
//            URLConnection mURLConnection = url.openConnection();
//            HttpsURLConnection mHttpsConnection = (HttpsURLConnection) mURLConnection;
//            mHttpsConnection.setRequestMethod("GET");
//            mHttpsConnection.connect();
//            mReader = new BufferedReader(new InputStreamReader(mHttpsConnection.getInputStream()));
//            String line;
//            while ((line = mReader.readLine()) != null) {
//                result = result + line;
//            }
//        } catch (Exception e) {
//            System.out.println("Get请求发送异常");
//            e.printStackTrace();
//        } finally {
//            try {
//                if (mReader != null) {
//                    mReader.close();
//                }
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) throws Exception {
//        String str = "";
//        HttpUtils testHttpRequres = new HttpUtils();
//        str = testHttpRequres.sentGET("泪目");
//        System.out.println(str);
//    }

