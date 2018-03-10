package com.tashi.testcalabash.Adapter;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tashi.testcalabash.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by SmartTahi on 2018/2/28.
 * PersonalFragment的界面适配
 */

public class PersonalFragmentAdapter extends RecyclerView.Adapter {

    private static final int MINE_HEAD = 0;
    private static final int MINE_OTHERS = 3;
    private ArrayList<String> date ;
    private HashMap<String,String> other;
    private ArrayList<Integer> images;

    public PersonalFragmentAdapter(ArrayList<String> date, HashMap<String,String> other,ArrayList<Integer> images) {
        this.date = date;
        this.images = images;
        this.other = other;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case MINE_HEAD:
                View top = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_fragment_item,parent,false);
                return new MineTopHolder(top);
           case MINE_OTHERS:
                View others = LayoutInflater.from(parent.getContext()).inflate(R.layout.personal_fragment_item,parent,false);
                return new MineOtherHolder(others);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MineTopHolder&&position==1){
            MineTopHolder topHolder = (MineTopHolder)holder;
            topHolder.headShot.setImageResource(Integer.parseInt(date.get(0)));
        }
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
 ImageView headShot;
 Text name;
 Text rank;
 Text folling_count;
 Text follwed_count;
    public MineTopHolder(View itemView) {
        super(itemView);
        headShot = itemView.findViewById(R.id.avator);
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