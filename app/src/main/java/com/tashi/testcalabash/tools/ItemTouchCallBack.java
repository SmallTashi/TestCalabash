package com.tashi.rvlapplication;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.tashi.testcalabash.Adapter.mAdapter;

import java.util.Collections;
import java.util.List;

/**
 * Created by SmartTahi on 2018/2/2.
 *
 */

public class ItemTouchCallBack extends ItemTouchHelper.Callback {

    private final mAdapter adapter;

    public ItemTouchCallBack(mAdapter adapter) {
        this.adapter = adapter;
    }

    @Override
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
        super.onSelectedChanged(viewHolder, actionState);
        if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
            viewHolder.itemView.setBackgroundColor(Color.WHITE);
            viewHolder.itemView.setAlpha((float) 0.5);
        }
    }

    @Override
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        viewHolder.itemView.setBackgroundColor(0);
        viewHolder.itemView.setAlpha(1);
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        int dragFlag;
        int swipeFlag;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {     //GridLayoutManager:拖拽可以细分为上下左右四个方向，但没有侧滑删除功能；
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.RIGHT ;    //若为其他LayoutManager则拖拽排序只有上下两个方向并且设置swipeFlag为ItemTouchHelper.END类型；
            swipeFlag = 0;
        } else {
            dragFlag = ItemTouchHelper.DOWN | ItemTouchHelper.UP;
            swipeFlag = ItemTouchHelper.END;
        }
        return makeMovementFlags(dragFlag, swipeFlag);
    }

    @Override       //在用户拖拽item时会回掉方法，参数中的viewHolder代表用户当前拖拽的item，而target代表的是；被用户拖拽所覆盖的item；
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        if (fromPosition < toPosition) {

            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap((List<?>) adapter.getDataList(), i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap((List<?>) adapter.getDataList(), i, i - 1);
            }
        }
        recyclerView.getAdapter().notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
        int position = viewHolder.getAdapterPosition();
        if (direction == ItemTouchHelper.END) {
            adapter.notifyItemRemoved(position);
        }
    }
}
