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

public class SelfieFragment extends Fragment {

    private static final String ARG_POSITION = "position";
    private int position;

    public static SelfieFragment newInstance(int position) {
        SelfieFragment f = new SelfieFragment();
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
        if (position == 1) {
            view = inflater.inflate(R.layout.selfie_fragment, container, false);
        }

        return view;
    }
}
