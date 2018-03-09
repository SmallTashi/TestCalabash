package com.tashi.testcalabash.tools;

import com.tashi.testcalabash.activity.LoginActivity;

/**
 * Created by SmartTahi on 2018/3/4.
 * 对用户输入的参数进行处理
 */

public class PackParameter {
    public static String article(String article_id){
        return "https://www.huluzc.com/article/"+article_id;
    }

    public static String change_headshot(String token,String url){
        return "token="+token+"&url="+url;
    }

    public static String Login (String phone,String password){
        return "{\"client\":\"android\",\"device_token\":\"Ag9b0kU1hJatcF_CKoX1ofzRSzVIn9rBrQhHTMjSg600\",\"device\":\"OPPO  3007\",\"account\":\""+phone+"\",\"device_id\":\"ffffffff-9d10-e796-0000-0000554590f9\",\"mac\":\"A0:AF:BD:DD:0F:95\",\"checkType\":\"password\",\"password\":\""+password+"\",\"version\":\"15\"}";
    }
    public static String ResetPassword(String newPassword,String phone,String verification){
        return "{\"rePwd\":\""+newPassword+"\",\"account\":\""+phone+"\",\"pwd\":\""+newPassword+"\",\"code\":\""+verification+"\",\"type\":\"username\"}";
    }
    public static String TagArticle(String Tag){
        return "https://www.huluzc.com/calabash/article?page=1&page_per=10&order_by=[\"praise_num\",\"published_time\"]&condition={\"tags\":[\""+Tag+"\"]}";
    }
    public static String TellNickName(String nick_name){
        return "https://www.huluzc.com/calabash/user/username?&username="+nick_name;
    }
    public static String Register(String username,String pwd,String verification){
        return "username="+username+"&password="+pwd;
    }
    public static String PassRegister(String username,String pwd){
        return "username="+username+"&password="+pwd;
    }


}
