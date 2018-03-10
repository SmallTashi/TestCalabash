package com.tashi.testcalabash.Date;

import android.media.Image;

import com.tashi.testcalabash.tools.HttpUtils;

/**
 * Created by SmartTahi on 2018/3/9.
 * 逼乎：问题列表
 */


 public class Question {
    private int id;
    private String title;
    private String content;
    private String images;
    private String date;
    private int exciting;
    private int naive;
    private int answerCount;
    private int authorId;
    private String authorName;
    private String authorAvatar;

  public Question(){}
    public static String put(String title, String content, String token){
        return  "title="+title+"&content="+content+"&token="+token;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExciting() {
        return exciting;
    }

    public void setExciting(int exciting) {
        this.exciting = exciting;
    }

    public int getNaive() {
        return naive;
    }

    public void setNaive(int naive) {
        this.naive = naive;
    }

    public int getAnswerCount() {
        return answerCount;
    }

    public void setAnswerCount(int answerCount) {
        this.answerCount = answerCount;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorAvatar() {
        return authorAvatar;
    }

    public void setAuthorAvatar(String authorAvatar) {
        this.authorAvatar = authorAvatar;
    }
}