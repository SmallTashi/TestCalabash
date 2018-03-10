package com.tashi.testcalabash.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tashi.testcalabash.R;

import java.util.ArrayList;
import java.util.List;



public class mAdapter extends RecyclerView.Adapter<mAdapter.mAdapterTextViewHolder> {
    private OnItemClickListener mItemClickListener;
    private ArrayList<Integer> freeImages = new ArrayList<>();
    private static ArrayList<String> answer = new ArrayList<>();

    mAdapter(Context context, ArrayList<String> answer, ArrayList<Integer> imageViews) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        mAdapter.answer = answer;
        this.freeImages = imageViews;
    }

    @Override
    public mAdapterTextViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //在创建View时判断显示类型进而范围不同的View
//        if (viewType == TYPE_ITEM) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mine_others_item, parent, false);
            return new mAdapterTextViewHolder(view);
//        } else if (viewType == TYPE_FOOTER) {
//            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_refresh_footer, parent, false);
//            return new FooterViewHolder(view);
//        }
//        return null;

    }

    @Override
    public void onBindViewHolder(final mAdapterTextViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        if (holder != null){
            mAdapterTextViewHolder recyclerViewHolder = (mAdapterTextViewHolder)holder;
//            adapterTextViewHolder.imageView.setImageResource(R.drawable.clounsum);
            //        String question = "你是谁啊？";
            recyclerViewHolder.imageView.setImageResource(freeImages.get(position));
//        holder.title.setText(question);
            recyclerViewHolder.content.setText(answer.get(position));
            if (mItemClickListener != null) {
                recyclerViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mItemClickListener.onItemClick(holder.itemView, position);
                    }
                });
            }
//        }else if (holder instanceof FooterViewHolder){
//            FooterViewHolder footerViewHolder =(mAdapter.FooterViewHolder) holder;
//            switch (loadState){
//                case LOADING:   //
//                    footerViewHolder.pbLoading.setVisibility(View.VISIBLE);
//                    footerViewHolder.loading.setVisibility(View.VISIBLE);
//                    footerViewHolder.llEnd.setVisibility(View.GONE);
//            }
        }
//        if(position==getItemCount()-1){
//            loadDate();
//       }
    }

//    private void loadDate() {
//        addMoreItem(answer,freeImages);
//    }

    @Override
    public int getItemViewType(int position) {  //将最后一个Item设置为FooterView
        return position;

    }

    public List getDataList() {
        return answer;
    }

    @Override
    public int getItemCount() {
        return answer.size();
    }


    class mAdapterTextViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView content = null;

        mAdapterTextViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.personal_sub_image);
//            title = (TextView) itemView.findViewById(R.id.text1);
            content = itemView.findViewById(R.id.personal_sub_text);
        }
    }

//    class FooterViewHolder extends mAdapter.mAdapterTextViewHolder {
//        TextView loading;
//        ProgressBar pbLoading;
//        RelativeLayout llEnd;

//        @SuppressLint("CutPasteId")
//        FooterViewHolder(View itemView) {
//            super(itemView);
//            pbLoading = (ProgressBar) itemView.findViewById(R.id.footer);
//            imageView = itemView.findViewById(R.id.footer_image);
//
//
//        }
 //   }

    void refreshItem(ArrayList<String> newItems, ArrayList<Integer> newImages) {
        answer.clear();
        freeImages.clear();
        addMoreItem(newItems, newImages);
    }

    private void addMoreItem(ArrayList<String> Items, ArrayList<Integer> Images) {
        answer.addAll(Items);
        freeImages.addAll(Images);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int Position);  //定义一个Item的回掉方法
    }

    void setOnItemClickListener(OnItemClickListener ItemClickListener) {
        this.mItemClickListener = ItemClickListener;    //定义一个设置监听器的方法
    }

}
