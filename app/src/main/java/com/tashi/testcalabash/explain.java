package com.tashi.testcalabash;

/**
 * Created by SmartTahi on 2018/3/8.
 * 有关JSON数据返回的说明
 */

public class explain {
    /**
     *成功登陆：
     {
     "code": "200",
     "data": {
     "clientId": "EY/2NMMyIUwpnPeLoBxPatJADR7xt6yl",
     "refreshToken": "AfWV5u4zrn2akcbyqDnsrhQOtozuC9mU",
     "tokenExpire": 1522844642,
     "accessToken": "4u8-773d9f5cab7dd4f98833",
     "user": {
     "username": "啊哦_4d87qa",
     "uid": "6350120776776028161",
     "rank": 5,
     "username": "17347898373",
     "birthday": "",
     "contact_email": "",
     "address": "",
     "qq": "",
     "designation": "",
     "gender": 0,
     "avatar": "https://q.qlogo.cn/qqapp/1106249891/9B05F565186FAC12C6CCEA9D99D2FBDE/100",
     "signature": "",
     "email": ""
     }
     }
     }

     成功注册：
     {
     "code": "201001",
     "data": {
     "username": "",
     "token": "22SASQ/hq00MQuhmpNuaFFYrFHR1zgk8",
     "uid": "6370819597679988737",
     "avatar": "https://smedia.huluzc.com/images/avatar/dinosaur.png"
     }
     }

     成功发送验证码：
     {"code": "204001", "data": {}}

     昵称可使用：
     {"code": "200001", "data": {}}
     不可使用:
     {"code": "400005", "data": {}}

     手机号或密码错误：
     {"code": "401001", "data": {}}

     手机号已注册：400

     推荐页：
     {
     "code": "200001",
     "data": {
     "count": 540,
     "page_per": 10,
     "page": 2,
     "result": [
     {
     "image": "https://smedia.huluzc.com/images/Android/image/280cdfed81004a79ab8f15b2e8592892.png",
     "topic": {
     "image": "https://smedia.huluzc.com/image/world/90217456-57d4-4a00-ae09-18ada24f1393",
     "is_first": true,
     "name": "职业人奇幻手记",
     "topic_id": "af106562bdea11e7a4650242ac120002"
     },
     "is_example": false,
     "created_time": 1519432027,
     "is_serialised": false,
     "category": 0,
     "big_image": "https://smedia.huluzc.com/image/theme/589edcb7-1788-48da-8b3c-1b99be60d2d5?imageView2/1/w/700/h/300&s=",
     "author": {
     "username": "一只名为二呆的猫",
     "following_num": 78,
     "user_id": "b2fa05e4db1211e7a4010242ac120003",
     "uid": "b2fa05e4db1211e7a4010242ac120003",
     "following_count": 78,
     "is_selected": false,
     "rank": 9,
     "article_count": 15,
     "avatar": "https://smedia.huluzc.com/user/avatar/wx/b2fa05e4db1211e7a4010242ac120003",
     "signature": "一个能决定自己的小齿轮。",
     "following": 78,
     "article_num": 15,
     "identity": {
     "category": 0,
     "state": 0,
     "name": ""
     }
     },
     "collection_num": 19,
     "chapter_title": "",
     "tags": "",
     "comment_num": 15,
     "introduce": "一个积极向上的反派不断自救的伪耽美故事。——该文由太好阳推荐。",
     "praise_num": 51,
     "is_deleted": false,
     "article_id": "6366628674364510209",
     "share_num": 0,
     "published_time": 1519432020,
     "serialised_praise_num": "",
     "read_times": 4988,
     "title": "反派boss的自我修养",
     "updated_time": 1520045088,
     "read_time": 300,
     "group_id": null
     },
     *主题世界：
     * {
     "code": "200001",
     "data": {
     "is_first": true,
     "rule_published_time": 1508143780,
     "nominated_articles":
     "image": "https://smedia.huluzc.com/images/iOS/article/e6c61eedbcac6853953504d448a1f03bc9c71b55be20f55373d24e55553218be.png",
     "unfold_count": 129,
     "created_time": 1506605641,
     "big_image": "https://smedia.huluzc.com/images/iOS/article/61e18becbe352921001e7355c5ffe00a19560322f017bea634fcf06ac7b5d5ff.png",
     "article_num": 129,
     "folded_count": 0,
     "is_selected": false,
     "content": "5f8e8e4ea45211e78f9a0242ac120003",
     "topic_id": "b02b1e36a45111e78f9a0242ac120003",
     "notice": "来一起嗨皮吧～ 我们是一群负责有趣的男神和女神——jing~",
     "tags": "轻松向",
     "introduce": "在远古时候，人高兴变成动物就能变成，动物要高兴也能变成人。那时候我们曾共用同样的话语，只因为，那时人和动物讲同样的话。我们发出同样的声音。……一起写一个童话故事吧^_^",
     "user": {
     "username": "赭玉",
     "following_num": 32,
     "article_num": 75,
     "avatar": "https://smedia.huluzc.com/images/iOS/article/e8930abddb58b05fa96bcda2aa20e953ccbf9345a0406ba0b3e5fb049f2f001c.png",
     "signature": "索性各自，心欢喜生",
     "identity": {
     "category": 0,
     "state": 0,
     "name": ""
     },
     "user_id": "6007eb909f5211e789830242ac120003",
     "rank": 10
     },
     "base_id": "5f8e8e4ea45211e78f9a0242ac120003",
     "following_num": 3272,
     "published_time": 1506605880,
     "name": "不正经的童话故事",
     "rule": " \r\n\t1. 必须是动物与人的故事哦。 比如说：河马先生爱上了猫，一个小鸡精居然成了真鸡精，屠龙的少年……\r\n  \r\n \r\n\t2. 要很不正经哦，幽默搞笑有内涵，不然我不喜欢哦～ 再来个么么哒就更好了～^_^\r\n  ",
     "updated_time": 1508222025,
     "base_article": {
     "article_id": "5f8e8e4ea45211e78f9a0242ac120003",
     "is_serialised": false
     },
     "figures": [

     ],
     "following": 3272
     }
     }
     * */
//    TO https://www.huluzc.com/calabash/article/nominate?page=1&page_per=2——page_per必须大于4
//    TO {"code": "422001", "data": [{"field": "page_per", "code": "invalid"}]}
/**
 * 接口没找着。。。所以直接换内容：（葫芦逼乎）
 * 注册：
 "status":200,
 "info":"success",
 "data":{
 "id":433,
 "username":"emmmmmmm",
 "password":"258146",
 "avatar":null,
 "token":"87d2766e59b598b5be89bbf922dc2212fad5ac5c"
 }
 登陆：
 "status":200,
 "info":"success",
 "data":
    {
     "id":433,
     "username":"emmmmmmm",
     "avatar":null,
     "token":"4c40d475452eac6cba4f46a7a8d0fbc39520cd4a"
    }
修改头像：
 {"status":200,"info":"success"}

 修改密码：
 "status":200,
 "info":"success",
 "data":{
 "token":"b9cc4f2d3031d2731afb727fd0c6bfde8c633de3"
    }

 *
 * */

}
