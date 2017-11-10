package com.ninefilta.ingnine.searchfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ninefilta.ingnine.R;

/**
 * Created by pajh8 on 2017-11-08.
 */

public class DailyFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    public static DailyFragment newInstance(int position) {
        DailyFragment f = new DailyFragment();
        Bundle b = new Bundle();
        b.putInt(ARG_POSITION, position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        position = getArguments().getInt(ARG_POSITION);
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = null;
        if(position == 2) {
            view = inflater.inflate(R.layout.daily_fragment, container, false);
        }

        return view;
    }
}
