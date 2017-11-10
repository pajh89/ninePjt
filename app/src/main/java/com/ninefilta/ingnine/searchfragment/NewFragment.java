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

public class NewFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    public static NewFragment newInstance(int position) {
        NewFragment f = new NewFragment();
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
        if(position == 0) {
            view = inflater.inflate(R.layout.new_fragment, container, false);
        }

        return view;
    }
}
