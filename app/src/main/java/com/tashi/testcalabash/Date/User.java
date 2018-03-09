package com.tashi.testcalabash.Date;

import android.os.Parcel;
import android.os.Parcelable;

/*
 "code": "200","data": {
 "token": "EY/2NMMyIUwpnPeLoBxPatJADR7xt6yl","refreshToken": "AfWV5u4zrn2akcbyqDnsrhQOtozuC9mU","tokenExpire": 1522844642,
 "accessToken": "4u8-773d9f5cab7dd4f98833","user": {
 "username": "啊哦_4d87qa","id": "6350120776776028161","rank": 5,"username": "17347898373",
 "birthday": "","contact_email": "","address": "","identity": {
 "category": 0,
 "state": 0,
 "name": ""},"qq": "","designation": "","gender": 0,
 "avatar": "https://q.qlogo.cn/qqapp/1106249891/9B05F565186FAC12C6CCEA9D99D2FBDE/100",
 "signature": "",
 "email": ""
 }
 */
public class User implements Parcelable{
    //跨Activity,Fragment 传递对象
    private int id ;
    private String username = "";
    private String password = "";
    private String avatar = "";
    private String token = "";
    public User(){}
    private User(Parcel in) {
        id = in.readInt();
        username = in.readString();
        password=in.readString();
        avatar = in.readString();
        token = in.readString();
    }

    //从流中创建一个用户对象
    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    //把用户对象写入流中
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(avatar);
        dest.writeString(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
