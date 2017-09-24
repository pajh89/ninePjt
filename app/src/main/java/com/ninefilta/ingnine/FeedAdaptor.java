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
 * Created by pajh8 on 2017-09-15.
 */




public class FeedAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<FeedItem> feedItems;
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

    public FeedAdaptor(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
        feedItems = new ArrayList<>();
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
        return feedItems.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    @Override
    public int getItemCount() {
        return feedItems.size();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FeedViewHolder) {
            FeedItem items = (FeedItem) feedItems.get(position);
            ((FeedViewHolder) holder).mftitle.setText(items.getFtitle());
            ((FeedViewHolder) holder).mftime.setText(items.getFtime());
        }


    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_ITEM) {
            return new FeedViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_listitem, parent, false));
        } else {
            return new ProgressViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress, parent, false));
        }

    }


    public void setMoreLoading(boolean isMoreLoading) {
        this.isMoreLoading=isMoreLoading;
    }

    public void addAll(ArrayList<FeedItem> lst){
        feedItems.clear();
        feedItems.addAll(lst);
        notifyDataSetChanged();
    }

    public void addItemMore(ArrayList<FeedItem> lst){
        feedItems.addAll(lst);
        notifyItemRangeChanged(0,feedItems.size());
    }




    public void setProgressMore(final boolean isProgress) {
        if (isProgress) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    feedItems.add(null);
                    notifyItemInserted(feedItems.size() - 1);
                }
            });
        } else {
            feedItems.remove(feedItems.size() - 1);
            notifyItemRemoved(feedItems.size());
        }
    }


    static class FeedViewHolder extends RecyclerView.ViewHolder {
        private TextView mftitle;
        private TextView mftime;

        public FeedViewHolder(View v) {
            super(v);
            mftitle = (TextView) itemView.findViewById(R.id.ftitle);
            mftime = (TextView) itemView.findViewById(R.id.ftime);
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

