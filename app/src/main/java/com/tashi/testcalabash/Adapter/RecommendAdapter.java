package com.tashi.testcalabash.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tashi.testcalabash.R;

/**
 * Created by SmartTahi on 2018/3/6.
 * 推荐页RecyclerView的Adapter
 */

public class RecommendAdapter extends RecyclerView.Adapter{

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
class RecommendViewHolder extends RecyclerView.ViewHolder{
    ImageView author_image;
    TextView author_id;
    TextView article_title;
    TextView article_intro;
    ImageView article_page;
    TextView article_collection;
    TextView article_faver;
    public RecommendViewHolder(View itemView) {
        super(itemView);
        author_image = itemView.findViewById(R.id.author_head);
        author_id = itemView.findViewById(R.id.author_id);
        article_title = itemView.findViewById(R.id.article_title);
        article_intro = itemView.findViewById(R.id.intro);
        article_page = itemView.findViewById(R.id.article_img);
        article_collection = itemView.findViewById(R.id.count_read);
        article_faver = itemView.findViewById(R.id.textView);
    }
}
