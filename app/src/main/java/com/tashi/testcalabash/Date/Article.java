package com.tashi.testcalabash.Date;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by SmartTahi on 2018/3/2.
 * 设置推荐界面的各个数据的类
 * BitMap:ViewPagerImage
 *作者头像：avatar
 * 作者名：username
 * 作品标题：title
 * 作品摘要：introduce
 * 作品封面：image
 * 喜欢数：praise_num
 * 浏览次数：read_times
 *
 "result": [
 {
 "image": "https://smedia.huluzc.com/image/article/1a2c58c4-8965-4d76-97cd-3e98e7465de2",
 "big_image": "https://smedia.huluzc.com/images/iOS/article/61e18becbe352921001e7355c5ffe00a19560322f017bea634fcf06ac7b5d5ff.png?imageView2/1/w/700/h/300&s=",
 "author": {
 "username": "左戚染",
 "following_num": 64,
 "user_id": "6348199199155163137",
 "uid": "6348199199155163137",
 "following_count": 64,
 "rank": 8,
 "article_count": 11,
 "avatar": "https://smedia.huluzc.com/image/avatar/1597150c-0b81-4ba0-97eb-16d5eaa5a181",
 "signature": "江湖上没红过的浪荡少女🌝",
 },
 "collection_num": 22,
 "comment_num": 28,
 "introduce": "谁还不是个小公主了～",
 "praise_num": 68,
 "article_id": "6370000703260200961",
 "published_time": 1520236920,
 "serialised_praise_num": "",
 "read_times": 4709,
 "title": "公主后妈要脱单",
 },
 * */
public class Article implements Parcelable {
    private String image;
    private Author author = new Author();
    private String article_title;
    private String introduce;
    private String praise_num;
    private String read_times;
    private String title;
    private static String username;
    private static String avatar;


    private Article(Parcel in) {
        image = in.readString();
        author.setUsername(in.readString());
        author.setAvatar(in.readString());
        article_title = in.readString();
        introduce = in.readString();
        praise_num = in.readString();
        read_times = in.readString();
        title = in.readString();
    }
    public Article(){}

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        Article.username = username;
    }

    public static String getAvatar() {
        return avatar;
    }

    public static void setAvatar(String avatar) {
        Article.avatar = avatar;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeString(author.getUsername());
        dest.writeString(author.getAvatar());
        dest.writeString(article_title);
        dest.writeString(introduce);
        dest.writeString(praise_num);
        dest.writeString(read_times);
        dest.writeString(title);
    }

    public static final Creator<Article> CREATOR = new Creator<Article>() {
        @Override
        public Article createFromParcel(Parcel in) {
            return new Article(in);
        }

        @Override
        public Article[] newArray(int size) {
            return new Article[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getAuthor_id() {
        return author.getUsername();
    }

    public void setAuthor_id(String author_id) {
        this.author.setUsername(author_id);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getPraise_num() {
        return praise_num;
    }

    public void setPraise_num(String praise_num) {
        this.praise_num = praise_num;
    }

    public String getRead_times() {
        return read_times;
    }

    public void setRead_times(String read_times) {
        this.read_times = read_times;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getAuthor_avatar() {
        return author.getAvatar();
    }

    public void setAuthor_avatar(String author_avatar) {
        author.setAvatar(author_avatar);
    }
}

/*"author": {
 "username": "左戚染",
 "following_num": 64,
 "user_id": "6348199199155163137",
 "uid": "6348199199155163137",
 "following_count": 64,
 "rank": 8,
 "article_count": 11,
 "avatar": "https://smedia.huluzc.com/image/avatar/1597150c-0b81-4ba0-97eb-16d5eaa5a181",
 "signature": "江湖上没红过的浪荡少女🌝",
 },*/

