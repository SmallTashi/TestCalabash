package com.tashi.testcalabash.tools;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by SmartTashi on 2018/3/1.
 * 开启网络请求Post与Get
 */
public class HttpUtils {
    private StringBuilder result =null;
    private BufferedReader mReader = null;
//获得验证码
    public void GetVerif(final String parameter,final String api) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = null;
                HttpsURLConnection connection = null;
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
                        connection.setRequestProperty("Content-Type","application/json;charset=UTF-8");
                        connection.setRequestProperty("Content-Length",String.valueOf(parameter.length()));
                        OutputStream out = connection.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    result = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                    //TODO
                } catch (ProtocolException e) {
                    e.printStackTrace();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
//                if(result!=null){
//                    return result.toString();
//                }else {
//                    return "Wrong!";
//                }
            }
        }).start();
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

