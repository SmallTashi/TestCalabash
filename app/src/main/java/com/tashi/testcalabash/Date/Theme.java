package com.tashi.testcalabash.Date;

/**
 * Created by SmartTahi on 2018/3/2.
 * 推荐界面：
 * 保存主题世界的各个元素数据类
 * 主题世界小头像：返回的Json中topic下的image
 * 主题世界大图：big_image
 * 主题名称：name
 * 主题id：topic_id
 *  PS：https://www.huluzc.com/worlds/+topic_id = WebView——主题世界
 *  分类界面：
 *  主题世界小头像：返回的Json中topic下的image
 *  主题名称：name
 *  主题id：topic_id
 */

/*
https://www.huluzc.com/calabash/topic/+topic_id
主题世界的Json
*/

public class Theme  {
    private String topic_id;
    private String name;
    private String image;
    private String bigImage;
    private String introduction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(String topic_id) {
        this.topic_id = topic_id;
    }
}

