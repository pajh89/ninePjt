package com.ninefilta.ingnine;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by pajh8 on 2017-09-26.
 */

public class ChangeBoxAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private ArrayList<ChageBoxItem> boxItems;
    private LinearLayoutManager mLinearLayoutManager;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;


    public ChangeBoxAdaptor(ArrayList<ChageBoxItem> items) {
        this.boxItems = items;
        boxItems = new ArrayList<ChageBoxItem>();
    }

    @Override
    public int getItemViewType(int position) {
        return boxItems.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager){
        this.mLinearLayoutManager=linearLayoutManager;
    }

    public void addAll(ArrayList<ChageBoxItem> lst){
        boxItems.clear();
        boxItems.addAll(lst);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return boxItems.size();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChageBoxViowHolder) {
            ChageBoxItem items = (ChageBoxItem) boxItems.get(position);
            ((ChageBoxViowHolder) holder).mChageID.setText(items.getChangeID());
            ((ChageBoxViowHolder) holder).mChageDate.setText(items.getChangeDate());
        }}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChageBoxViowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.changebox_listitem, parent, false));
    }


    static class ChageBoxViowHolder extends RecyclerView.ViewHolder {
        private TextView mChageID;
        private TextView mChageDate;

        public ChageBoxViowHolder(View v) {
            super(v);
            mChageID = (TextView) v.findViewById(R.id.boxChangeId);
            mChageDate = (TextView) v.findViewById(R.id.boxChangeDate);
        }

    }
}
