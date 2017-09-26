package com.ninefilta.ingnine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by pajh8 on 2017-09-26.
 */

public class ChangeBoxFragment extends Fragment{

    LinearLayoutManager mLayoutManager;
    ArrayList<ChageBoxItem> mBoxItem;
    RecyclerView mRecyclerView;
    ChangeBoxAdaptor mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.changebox, container, false);

        mBoxItem = new ArrayList<ChageBoxItem>();
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recy_box);
        mAdapter = new ChangeBoxAdaptor(mBoxItem);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter.setLinearLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


        return rootView;
    }


    @Override
    public void onResume() {
        super.onResume();
        loadData();
    }

    private void loadData() {
        mBoxItem.clear();
        for (int i = 1; i <= 10; i++) {
            mBoxItem.add(new ChageBoxItem("셀피", ""+i));
        }
        mAdapter.addAll(mBoxItem);
    }
}
