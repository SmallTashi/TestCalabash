package com.tashi.testcalabash.Adapter;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tashi.testcalabash.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by SmartTahi on 2018/2/28.
 * PersonalFragment的界面适配
 */

public class PersonalFragmentAdapter extends RecyclerView.Adapter {

    private static final int MINE_HEAD = 0;
    private static final int MINE_SUBSCRIBE = 1;
    private static final int MINE_BOOK = 2;
    private static final int MINE_OTHERS = 3;
    private ArrayList<String> date ;

    public PersonalFragmentAdapter(ArrayList<String> date) {
        this.date = date;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case MINE_HEAD:
                break;
            case MINE_SUBSCRIBE:
                //TODO
                break;
            case MINE_BOOK:
                //TODO
                break;
            case MINE_OTHERS:
                //TODO
                break;
        }

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }


    @Override
    public int getItemCount() {
        return 12;
    }


}

class MineTopHolder extends RecyclerView.ViewHolder {
private ImageView headShot;
private Text name;
private Text rank;
private Text folling_count;
private Text follwed_count;
    public MineTopHolder(View itemView) {
        super(itemView);
        headShot = (ImageView) itemView.findViewById(R.id.avator);
        name = itemView.findViewById(R.id.user_name);
        rank = itemView.findViewById(R.id.rank);
        folling_count = itemView.findViewById(R.id.following_num);
        follwed_count = itemView.findViewById(R.id.followed_num);
    }

}

class MineMidHolder extends RecyclerView.ViewHolder {

   View mView;
     ImageView mImageView;
 Text mText;
private TabLayout mTabLayout;
    public MineMidHolder(View itemView) {
        super(itemView);
        mView = itemView;
        mImageView = itemView.findViewById(R.id.personal_sub_image);
        mText = itemView.findViewById(R.id.personal_sub_text);
        mTabLayout = itemView.findViewById(R.id.tab);

    }

}

class MineOtherHolder extends RecyclerView.ViewHolder {
ImageView icon;
Text message;
    public MineOtherHolder(View itemView) {
        super(itemView);
        icon=itemView.findViewById(R.id.mine_icon);
        message = itemView.findViewById(R.id.mine_item_others);
    }
}