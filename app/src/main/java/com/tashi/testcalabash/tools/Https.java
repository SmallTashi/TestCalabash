package com.tashi.testcalabash.tools;

/**
 * Created by SmartTahi on 2018/3/10.
 */


import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class Https {
    private StringBuilder result = null;
    private BufferedReader mReader = null;

    //获得验证码
    public static void GetVerif(final String parameter, final String api) {
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
                connection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                connection.setRequestProperty("Content-Length", String.valueOf(parameter.length()));
                OutputStream out = connection.getOutputStream();
                out.write(parameter.getBytes());
                out.close();
            }
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
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
            }
        }).start();
    }
}