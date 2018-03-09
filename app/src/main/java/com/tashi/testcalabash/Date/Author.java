package com.tashi.testcalabash.Date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SmartTahi on 2018/3/8.
 * 作者信息
 */

public class Author implements Parcelable {
    private static String username;
    private static String user_id;
    private static int following;
    private static int rank;
    private static int article_count;
    private static String avatar;
    private static String signature;

    public Author(){}
    private Author(Parcel in) {
        username = in.readString();

        user_id =in.readString();
        following =in.readInt();
        rank = in.readInt();
        article_count =in.readInt();
        avatar =in.readString();
        signature =in.readString();
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(username);
        dest.writeString(user_id);
        dest.writeInt(following);
        dest.writeInt(rank);
        dest.writeInt(article_count);
        dest.writeString(avatar);
        dest.writeString(signature);
    }

    public static final Creator<Author> CREATOR = new Creator<Author>() {
        @Override
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        @Override
        public Author[] newArray(int size) {
            return new Author[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        Author.username = username;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        Author.signature = signature;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        Author.avatar = avatar;
    }

    public  int getRank() {
        return rank;
    }

    public  void setRank(int rank) {
        Author.rank = rank;
    }

    public  int getArticle_count() {
        return article_count;
    }

    public  void setArticle_count(int article_count) {
        Author.article_count = article_count;
    }

    public  int getFollowing() {
        return following;
    }

    public  void setFollowing(int following_count) {
        Author.following = following_count;
    }


    public  String getUser_id() {
        return user_id;
    }

    public  void setUser_id(String user_id) {
        Author.user_id = user_id;
    }
}