package com.ninefilta.ingnine;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import static com.ninefilta.ingnine.R.id.myworkList;

/**
 * Created by pajh8 on 2017-09-29.
 */

public class MyWorkFragment extends Fragment implements MyWorkAdaptor.OnLoadMoreListener{

    LinearLayoutManager mLayoutManager;
    ArrayList<MyWorkItem> mMyWorkItem;
    RecyclerView mRecyclerView;
    MyWorkAdaptor mAdapter;
    GestureDetector gestureDetector;
    DetailItemFragment detailItemFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.my_mywork, container, false);

        mMyWorkItem = new ArrayList<MyWorkItem>();
        mRecyclerView = (RecyclerView) rootView.findViewById(myworkList);
        mAdapter = new MyWorkAdaptor(this);
        mAdapter.setRecyclerView(mRecyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setLinearLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

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

                Bundle deatilBundle = new Bundle();
                //   feedBundle.putInt(FeedFragment.ARG_POSITION, position);
                detailItemFragment.setArguments(deatilBundle);

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
    public void onLoadMore() {
        mAdapter.setProgressMore(true);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mMyWorkItem.clear();
                mAdapter.setProgressMore(false);


                int start = mAdapter.getItemCount();
                int end = start + 10;
                for (int i = start + 1; i <= end; i++) {
                    mMyWorkItem.add(new MyWorkItem("셀피", "가나다라마다바라러사아" +i));
                }

                mAdapter.addItemMore(mMyWorkItem);
                mAdapter.setMoreLoading(false);
            }
        }, 2000);
    }

    private void loadData() {
        mMyWorkItem.clear();
        for (int i = 1; i <= 10; i++) {
            mMyWorkItem.add(new MyWorkItem("Natural", "아자타카카타파하" +i));
        }
        mAdapter.addAll(mMyWorkItem);
    }


}
