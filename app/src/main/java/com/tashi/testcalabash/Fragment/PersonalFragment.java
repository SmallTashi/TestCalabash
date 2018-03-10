package com.tashi.testcalabash.Fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tashi.testcalabash.Date.User;
import com.tashi.testcalabash.R;
import com.tashi.testcalabash.tools.MyApplication;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SmartTahi on 2018/2/27.
 *
 */

public class PersonalFragment extends Fragment {

    HashMap<String,String> mine = new HashMap<>();
    HashMap<String,String> other = new HashMap<>();
    private ArrayList<Integer> images = null;
    private ArrayList<String> text = null;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private User mUser = MyApplication.getUser();
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.personal_fragment,container,false);
        inisital();
        mSwipeRefreshLayout = view.findViewById(R.id.refreshLayout);   //绑定布局中的SwipeRefreshLayout控件
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            //设置监听器，覆写执行对应操作刷新的方法
            @Override
            public void onRefresh() {
                refreshItem();
            }
        });
        return view;
    }

    public void inisital(){

        mine.put("top_name", mUser.getUsername());
        mine.put("user_avatar", mUser.getAvatar());
        mine.put("following","0") ;
        mine.put("fllowed","0");
        this.images = new ArrayList<>();
        images.add(R.drawable.disamoon);

        images.add(R.drawable.vosnow);

        images.add(R.drawable.frog);

        images.add(R.drawable.bigrain);

        images.add(R.drawable.elec);

        images.add(R.drawable.clounsum);

        images.add(R.drawable.lightsnow);

        images.add(R.drawable.vosnow);

        images.add(R.drawable.frog);

        images.add(R.drawable.vosnow);

        images.add(R.drawable.disamoon);
    }
    void refreshItem() {
        //模拟刷新数据
        this.inisital();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                try {
////                    temp.addAll(answer);
////                    answer.clear();
//                    for (int i = answer.size()-1; i >= 0; i--) {    //更新数据——不要把循环的个数写死。。不然很容易出Bug
//                        newItems.add(answer.get(i) + "\nadd\n" + ((100+number) + i));
//                        newImages.add(images.get(i));
//                    }
//                    Thread.sleep(1000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        mSwipeRefreshLayout.setRefreshing(false);   //关闭下拉刷新的动画
//                        number+=10;
//                        newImages.addAll(images);
//                        newItems.addAll(answer);
//                        adapter.refreshItem(newItems,newImages);
//                        newItems.clear();   //每次刷新后清空链表。。以防出现重复的Item
//                        newImages.clear();
//                    }
//                });
            }
        }).start();
    }
}
