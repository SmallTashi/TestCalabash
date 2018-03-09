package com.tashi.testcalabash.tools;

/**
 * Created by SmartTahi on 2018/3/3.
 * 处理传入的的参数
 */

public class package_param {
    public static String Register(String verification, String pwd, String phone){
        return "\"pwd\":\""+pwd+"\",\"client\":\"android\",\"source\":\"yingyongbao\",\"account\":\""+phone+"\",\"device_id\":\"ffffffff-9d10-e796-0000-0000554590f9\",\"code\":\""+verification+"\",\"type\":\"username\",\"agree\":\"1\"";
    }
    public static String Login(String phone,String pwd){
        return  "\"client\":\"android\",\"device_token\":\"Ag9b0kU1hJatcF_CKoX1ofzRSzVIn9rBrQhHTMjSg600\",\"device\":\"OPPO  3007\",\"account\":\""+phone+"\",\"device_id\":\"ffffffff-9d10-e796-0000-0000554590f9\",\"mac\":\"A0:AF:BD:DD:0F:95\",\"checkType\":\"password\",\"password\":\""+pwd+"\",\"version\":\"15\"";
    }

}
