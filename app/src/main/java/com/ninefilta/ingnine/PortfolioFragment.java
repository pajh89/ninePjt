package com.ninefilta.ingnine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 *
 */

public class PortfolioFragment extends Fragment{
    LinearLayoutManager mLayoutManager;
    ArrayList<PortfolioItem> mPortfolioItem;
    RecyclerView mRecyclerView;
    PortfolioAdaptor mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.portfolio_fragment, container, false);


        mPortfolioItem = new ArrayList<PortfolioItem>();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recy_port);
        mAdapter = new PortfolioAdaptor(mPortfolioItem);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setLinearLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        final ImageView boxChange = (ImageView) rootView.findViewById(R.id.boxChange);
        boxChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangeBoxFragment boxChangeFragment = new ChangeBoxFragment();
                FragmentManager fmanager = getFragmentManager();
                FragmentTransaction ftrans = fmanager.beginTransaction();
                ftrans.replace(R.id.container, boxChangeFragment);
                ftrans.addToBackStack(null);
                ftrans.commit();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        mPortfolioItem.clear();
        for (int i = 1; i <= 10; i++) {
            mPortfolioItem.add(new PortfolioItem(""+i, "가나다라마바사가기가구가기러랴미아러안됍니다안돼"));
        }
        mAdapter.addAll(mPortfolioItem);
    }
}
