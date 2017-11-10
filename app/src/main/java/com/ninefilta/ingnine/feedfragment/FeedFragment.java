package com.ninefilta.ingnine.feedfragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ninefilta.ingnine.DetailItemFragment;
import com.ninefilta.ingnine.R;

import java.util.ArrayList;

import static com.ninefilta.ingnine.R.id.recyclerView;

/**
 *
 */

public class FeedFragment extends Fragment implements FeedAdaptor.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{

    LinearLayoutManager mLayoutManager;
    ArrayList<FeedItem> mFeedItem;
    RecyclerView mRecyclerView;
    FeedAdaptor mAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout;
    GestureDetector gestureDetector;
    DetailItemFragment detailItemFragment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.feed_fragment, container, false);

        mFeedItem = new ArrayList<FeedItem>();
        mRecyclerView = (RecyclerView) rootView.findViewById(recyclerView);
        mAdapter = new FeedAdaptor(this);
        mAdapter.setRecyclerView(mRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setLinearLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_layout);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        gestureDetector = new GestureDetector(getContext(),new GestureDetector.SimpleOnGestureListener() {

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }
        });

        mRecyclerView.addOnItemTouchListener(onItemTouchListener);

        return rootView;
    }

    RecyclerView.OnItemTouchListener onItemTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View childView = rv.findChildViewUnder(e.getX(),e.getY());

            if(childView != null && gestureDetector.onTouchEvent(e)){

                //int currentPosition = rv.getChildAdapterPosition(childView);
                //FeedItem currentItemFeed = mFeedItem.get(currentPosition);
                detailItemFragment = new DetailItemFragment();
                FragmentManager fmanager = getFragmentManager();
                FragmentTransaction ftrans = fmanager.beginTransaction();
                ftrans.replace(R.id.container, detailItemFragment);
                ftrans.addToBackStack(null);
                ftrans.commit();

                return true;

            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }
    };


    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    @Override
    public void onRefresh() {
        Log.d("MainActivity_","onRefresh");
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
                loadData();

            }
        },2000);
    }


    @Override
    public void onLoadMore() {
        mAdapter.setProgressMore(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mFeedItem.clear();
                mAdapter.setProgressMore(false);


                int start = mAdapter.getItemCount();
                int end = start + 10;
                for (int i = start + 1; i <= end; i++) {
                    mFeedItem.add(new FeedItem("가나다바", "1시간 전" +i));
                }

                mAdapter.addItemMore(mFeedItem);
                mAdapter.setMoreLoading(false);
            }
        }, 2000);
    }

    private void loadData() {
        mFeedItem.clear();
        for (int i = 1; i <= 10; i++) {
            mFeedItem.add(new FeedItem("가나다라마바사", "2시간 전" +i));
        }
        mAdapter.addAll(mFeedItem);
    }


}
