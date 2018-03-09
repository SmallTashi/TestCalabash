package com.tashi.testcalabash.tools;

import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by SmartTashi on 2018/3/1.
 * 开启网络请求Post与Get
 * <p>
 * 400——该手机号已注册
 * {"code": "401001", "data": {}}——用户名或密码错误，请重新输入
 * {"code": "200001", "data": {}}——昵称可用
 * {"code": "400005", "data": {}}——昵称已使用
 * {"code": "204001", "data": {}}——成功发送验证码
 * {"code": "201001", "data": {"username": "", "token": "22SASQ/hq00MQuhmpNuaFFYrFHR1zgk8", "uid": "6370819597679988737", "avatar": "https://smedia.huluzc.com/images/avatar/dinosaur.png"}}
 * ——成功注册
 */
public class HttpUtils {

    private static HttpURLConnection connection = null;

    public static void sentHttpRequest(final String parameter, final String api, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //"https://www.huluzc.com/calabash/code/phone?"+"&username="+pa+"&category=0"
                    URL url = new URL(api);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(5 * 1000);
                    connection.setConnectTimeout(10 * 1000);
                    if (parameter == null) {
                        connection.setRequestMethod("GET");
                        connection.connect();
                    } else {
                        connection.setRequestMethod("POST");
                        connection.setDoInput(true);
                        connection.setDoOutput(true);
                        connection.setUseCaches(false);
                        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        OutputStream out = connection.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    if (connection.getResponseCode() == 200) {
                        final byte[] temp = ReadStream(connection.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSuccess(new Response(temp));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    callback.onFiled(e);
                                }
                                //使用回调，返回请求得到的数据
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFiled(new Exception("网络连接失败"));
                            }
                        });
                    }
                } catch (final ProtocolException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } finally {
                    if (connection != null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public static String getJSONOf(String date, String name) {
        try {
            return new JSONObject(date).getString(name);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static byte[] ReadStream(InputStream in) {
        //建立通道对象
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //创建保存数据的字节数组
        byte[] temp = new byte[1024];
        //开始读取数据
        int len;
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

    public interface Callback {
        void onSuccess(Response response) throws JSONException;

        void onFiled(Exception e);
    }

    public static class Response {
        private int State;
        private String Info;
        private String Date = null;

        Response(byte[] response) throws JSONException {
            String rawDate = new String(response);
            JSONObject object = new JSONObject(rawDate);
            State = object.getInt("status");
            Info = object.getString("info");
            Date = new JSONObject(rawDate).getString("data");
        }

        public String getInfo() {
            return Info;
        }

        public String getDate() {
            return Date;
        }

        public int getState() {
            return State;
        }
    }


    private static HttpsURLConnection connections = null;

    public static void sentHttpsRequest(final String parameter, final String api, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //"https://www.huluzc.com/calabash/code/phone?"+"&username="+pa+"&category=0"
                    URL url = new URL(api);
                    connections = (HttpsURLConnection) url.openConnection();
                    connections.setReadTimeout(5 * 1000);
                    connections.setConnectTimeout(10 * 1000);
                    if (parameter == null) {
                        connections.setRequestMethod("GET");
                        connections.connect();
                    } else {
                        connections.setRequestMethod("POST");
                        connections.setDoInput(true);
                        connections.setDoOutput(true);
                        connections.setUseCaches(false);
                        connections.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                        OutputStream out = connections.getOutputStream();
                        out.write(parameter.getBytes());
                        out.close();
                    }
                    if (connections.getResponseCode() == 200) {
                        final byte[] temp = ReadStream(connections.getInputStream());
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                try {
                                    callback.onSuccess(new Response(temp));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    callback.onFiled(e);
                                }
                                //使用回调，返回请求得到的数据
                            }
                        });
                    } else {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onFiled(new Exception("网络连接失败"));
                            }
                        });
                    }
                } catch (final ProtocolException e) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } catch (final IOException e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            callback.onFiled(e);
                        }
                    });
                } finally {
                    if (connections != null) {
                        connections.disconnect();
                    }
                }
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

