package com.ninefilta.ingnine.portfoliofragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninefilta.ingnine.R;

import java.util.ArrayList;

/**
 * Created by pajh8 on 2017-09-17.
 */

public class PortfolioAdaptor extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<PortfolioItem> portfolioItems;
    private LinearLayoutManager mLinearLayoutManager;

    private final int VIEW_ITEM = 1;
    private final int VIEW_PROG = 0;


    public PortfolioAdaptor(ArrayList<PortfolioItem> items) {
        this.portfolioItems = items;
        portfolioItems = new ArrayList<PortfolioItem>();
    }

    @Override
    public int getItemViewType(int position) {
        return portfolioItems.get(position) != null ? VIEW_ITEM : VIEW_PROG;
    }

    public void setLinearLayoutManager(LinearLayoutManager linearLayoutManager){
        this.mLinearLayoutManager=linearLayoutManager;
    }

    public void addAll(ArrayList<PortfolioItem> lst){
        portfolioItems.clear();
        portfolioItems.addAll(lst);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return portfolioItems.size();
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PortfolioViowHolder) {
            PortfolioItem items = (PortfolioItem) portfolioItems.get(position);
            ((PortfolioViowHolder) holder).mboxNum_Port.setText(items.getBoxNum_Port());
            ((PortfolioViowHolder) holder).mtitle_Port.setText(items.getTitle_Port());
        }}

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PortfolioViowHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_listitem, parent, false));
    }


    static class PortfolioViowHolder extends RecyclerView.ViewHolder {
        private TextView mboxNum_Port;
        private TextView mtitle_Port;

        public PortfolioViowHolder(View v) {
            super(v);
            mboxNum_Port = (TextView) v.findViewById(R.id.boxNum_port);
            mtitle_Port = (TextView) v.findViewById(R.id.title_Port);
        }

    }
}

