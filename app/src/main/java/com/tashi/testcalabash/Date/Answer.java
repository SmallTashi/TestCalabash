package com.tashi.testcalabash.Date;

/**
 * Created by SmartTahi on 2018/3/10.
 */

public class Answer{
    private String page;
    private String count;
    private String token;

    public String getList(String page,String count,String token){
        return "page="+page+"&count="+count+"&token="+token;
    }
}