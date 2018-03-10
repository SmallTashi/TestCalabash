package com.tashi.testcalabash.tools;

/**
 * Created by SmartTahi on 2018/3/2.
 * 接口类
 */

public class Api {

    public static final String BH_CONCERCOLLECTION = "http://bihu.jay86.com/cancelFavorite.php";
    public static final String BH_COLLECTION = "http://bihu.jay86.com/favorite.php";
    public static final String BH_LISTANSWE= "http://bihu.jay86.com/getAnswerList.php";
    public static final String BH_PUTANSWER = "http://bihu.jay86.com/answer.php";
    public static final String BH_LISTQUSTION = "http://bihu.jay86.com/getQuestionList.php";
    public static final String BH_PUTQUSTION= "http://bihu.jay86.com/question.php";
    public static final String BH_LOGIN = "http://bihu.jay86.com/login.php";
    public static final String BH_REGISTER ="http://bihu.jay86.com/register.php";
    public static final String CHANG_HEAD_SHOT="http://bihu.jay86.com/modifyAvatar.php";
    //@param :page&page_per
    public static final String ATTICAL_LIST_head = "https://www.huluzc.com/calabash/article/nominate?"; //200001
    //comments
    //@param：article_id
    public static final String COMMENT_head = "www.huluzc.com/calabash/article/";   //200001
    public static final String COMMENT_foot = "/comment";
    //Get Verification
    //param:phone_number
    public static final String VERIFICATION_head = "https://www.huluzc.com/calabash/code/username?&username=";
    public static final String VERIFICATION_foot = "&category=0";   //204001
    //Post Login
    //param:phone_number&password
    public static final String HL_LOGIN = "https://www.huluzc.com/calabash/session";
    //Post Reset
    //param:verification&phone_number&new_password;
    //get_Verification  param:username
    public static final String RESET_step1H = "https://www.huluzc.com/calabash/code/username?&username=";
    public static final String RESET_step1F = "&category=0";
    public static final String REGISTER = "https://www.huluzc.com/calabash/user-v2";

    public static final String HL_All_article = "https://www.huluzc.com/calabash/article?page=1&page_per=40&order_by=[\"praise_num\",\"published_time\"]&condition={\"tags\":[]}";

    //post_new_password param:username&password&password&verification
    public static final String RESET_step2 = "https://www.huluzc.com/calabash/user/password";
    public static final String HL_THEME_VIEW_PAGER = "https://www.huluzc.com/calabash/figure?category=1&client_category=web";
    public static final String HL_RECOMMEND_VIEW_PAGER = "https://www.huluzc.com/calabash/figure?category=0&client_category=web";
    //get theme_world
    //topic_id
    public static final String HL_THEME_WORLD = "https://www.huluzc.com/worlds/";
    //Recommend_article_api
    public static final String HL_RECOMMEND_ALL = "https://www.huluzc.com/calabash/article/nominate?page=1&page_per=10";
    //get tell username
    //param : user_name

}
