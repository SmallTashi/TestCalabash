package com.tashi.testcalabash.tools;

import android.util.Log;

import com.tashi.testcalabash.Date.Author;
import com.tashi.testcalabash.Date.Question;
import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.Date.Article;
import com.tashi.testcalabash.Date.Theme;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by SmartTahi on 2018/3/2.
 * 解析获得的JSON数据
 */

public class JSONmanager {
    public static User newUser(String date) throws JSONException {
        JSONObject object = new JSONObject(date);
        User user = new User();
        try {
            user.setAvatar(object.getString("avatar"));
            user.setToken(object.getString("token"));
                user.setUsername(object.getString("username"));
                user.setId(object.getInt("uid"));
            }catch (JSONException e){
            e.printStackTrace();
            Log.w("tag",e);
        }
        return user;
    }
    public static User getUser(String date) throws JSONException {
        JSONObject object = new JSONObject(date);
        User user = new User();
        try {
            user.setToken(object.getString("token"));
            user.setAvatar(object.getString("avatar"));
            user.setUsername(object.getString("username"));
            user.setId(object.getInt("id"));
        }catch (JSONException e){
            e.printStackTrace();
            Log.w("tag_user",e);
        }
        return user;
    }

    public static void ChangePwd(User user,String date) throws JSONException {
        JSONObject object = new JSONObject(date);
        user.setToken(object.getString("token"));
    }

    public static ArrayList<Question> getQuestionList(String date) throws JSONException {
        ArrayList<Question> questions = new ArrayList<>();
        try {
            JSONObject item = new JSONObject(date);
            JSONArray question = new JSONArray("question");
            for (int i = 0; i <question.length() ; i++) {
                Question questionItem = new Question();
                JSONObject object = question.getJSONObject(i);
                questionItem.setContent(object.getString("content"));
                questionItem.setImages(object.getString("image"));
                questionItem.setAnswerCount(object.getInt("answerCount"));
                questionItem.setAuthorId(object.getInt("authorId"));
                questionItem.setTitle(object.getString("title"));
                questionItem.setDate(object.getString("date"));
                questionItem.setNaive(object.getInt("naive"));
                questionItem.setAuthorName(object.getString("authorName"));
                questionItem.setExciting(object.getInt("exciting"));
questionItem.setId(object.getInt("id"));
questionItem.setAuthorAvatar(object.getString("authorAvatar"));

            }
        }catch (JSONException e){
            e.printStackTrace();
            Log.w("tag_recommend",e);
        }
        return questions;
    }


    public static ArrayList<Article> getRecommendItem(String date) throws JSONException {
        ArrayList<Article> article = new ArrayList<>();
        try {
            JSONObject item = new JSONObject(date);
            JSONArray recommendArray = new JSONArray("result");
            for (int i = 0; i <recommendArray.length() ; i++) {
                Article articleItem = new Article();
                JSONObject object = recommendArray.getJSONObject(i);
                articleItem.setImage(object.getString("image"));
                {
                    JSONObject th = new JSONObject(object.getString("topic"));
                    Theme topic = new Theme();
                    topic.setName(th.getString("name"));
                    topic.setTopic_id(th.getString("topic_id"));

                }
                {
                    JSONObject au = new JSONObject(object.getString("author"));
                    articleItem.setAuthor_id(au.getString("username"));
                    articleItem.setAuthor_avatar(au.getString("avatar"));
                }
                articleItem.setIntroduce(object.getString("introduce"));
                articleItem.setPraise_num(object.getString("praise_num"));
                articleItem.setArticle_title(object.getString("article_title"));
                articleItem.setRead_times(object.getString("read_times"));
                articleItem.setTitle(object.getString("title"));
            }
        }catch (JSONException e){
            e.printStackTrace();
            Log.w("tag_recommend",e);
        }
        return article;
    }
    public static Author getAuthor(String date) throws JSONException {
        JSONObject object = new JSONObject(date);
        Author author = new Author();
        try {
            author.setArticle_count(object.getInt("article_count"));
            author.setAvatar(object.getString("avatar"));
            author.setUsername(object.getString("username"));
            author.setFollowing(object.getInt("following_count"));
            author.setSignature(object.getString("signature"));
            author.setUser_id(object.getString("uid"));
            author.setRank(object.getInt("rank"));
            return author;
        }catch (JSONException e){
            Log.w("tag_author",e);
        }
        return author;
    }
    public static Theme getTopic(String date) throws JSONException {
        JSONObject object = new JSONObject(date);
        Theme topic = new Theme();
        try {
            topic.setBigImage(object.getString("big_image"));
            topic.setImage(object.getString("image"));
            topic.setIntroduction(object.getString("introduce"));
            topic.setTopic_id(object.getString("topic_id"));
            topic.setName(object.getString("name"));
        }catch (JSONException e){
            e.printStackTrace();
            Log.w("Tag_theme",e);
        }
        return topic;
    }


}

/*
  现在是2018.3.8
  距离deadline还有约36个小时
  整理思路：
  目标:
  实现四个Fragment的RecyclerView
  WebView加载文章内容，作者主页，个人主页，主题世界
  点赞，收藏，喜欢，更换头像
  各个RecyclerView的ViewHolder：
  theme_item   recommend   personal    find
  序列化对象：article✓    User✓    topic


  */
