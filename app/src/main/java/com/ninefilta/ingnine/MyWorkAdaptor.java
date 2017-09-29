package com.ninefilta.ingnine;

import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pajh8 on 2017-09-29.
 */

public class MyWorkAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private ArrayList<MyWorkItem> myWorkItems;
    private OnLoadMoreListener onLoadMoreListener;
    private LinearLayoutManager mLinearLayoutManager;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;

    private boolean isMoreLoading = false;
    private int visibleThreshold = 1;
    int firstVisibleItem, visibleItemCount, totalItemCount, lastVisibleItem;


    public interface OnLoadMoreListener{
        void onLoadMore();
    }

    public MyWorkAdaptor(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
        myWorkItems = new ArrayList<>();
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager){
        this.mLinearLayoutManager=linearLayoutManager;
    }

    public void setRecyclerView(RecyclerView mView){
        mView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                visibleItemCount = recyclerView.getChildCount();
                totalItemCount = mLinearLayoutManager.getItemCount();
                firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
                lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
                Log.d("total", totalItemCount + "");
                Log.d("visible", visibleItemCount + "");

                Log.d("first", firstVisibleItem + "");
                Log.d("last", lastVisibleItem + "");

                if (!isMoreLoading && (totalItemCount - visibleItemCount)<= (firstVisibleItem + visibleThreshold)) {
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                    isMoreLoading = true;
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return myWorkItems.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    @Override
    public int getItemCount() {
        return myWorkItems.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyWorkViewHolder) {
            MyWorkItem items = (MyWorkItem) myWorkItems.get(position);
            ((MyWorkViewHolder) holder).mFCtg.setText(items.getMfCTG());
            ((MyWorkViewHolder) holder).mFTitle.setText(items.getMfTitle());
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_ITEM) {
            return new MyWorkViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.my_mywork_listitem, parent, false));
        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress, parent, false));
        }

    }


    public void setMoreLoading(boolean isMoreLoading) {
        this.isMoreLoading=isMoreLoading;
    }

    public void addAll(ArrayList<MyWorkItem> lst){
        myWorkItems.clear();
        myWorkItems.addAll(lst);
        notifyDataSetChanged();
    }

    public void addItemMore(ArrayList<MyWorkItem> lst){
        myWorkItems.addAll(lst);
        notifyItemRangeChanged(0,myWorkItems.size());
    }




    public void setProgressMore(final boolean isProgress) {
        if (isProgress) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    myWorkItems.add(null);
                    notifyItemInserted(myWorkItems.size() - 1);
                }
            });
        } else {
            myWorkItems.remove(myWorkItems.size() - 1);
            notifyItemRemoved(myWorkItems.size());
        }
    }


    static class MyWorkViewHolder extends RecyclerView.ViewHolder {
        private TextView mFCtg;
        private TextView mFTitle;

        public MyWorkViewHolder(View v) {
            super(v);
            mFCtg = (TextView) itemView.findViewById(R.id.fCtg);
            mFTitle = (TextView) itemView.findViewById(R.id.fTitle);
        }

    }

    static class ProgressViewHolder extends RecyclerView.ViewHolder {
        public ProgressBar pBar;
        public ProgressViewHolder(View v) {
            super(v);
            pBar = (ProgressBar) v.findViewById(R.id.pBar);
        }
    }


}
