package com.ninefilta.ingnine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by pajh8 on 2017-09-17.
 */

public class MyFragment extends Fragment {

    TextView mMywork;
    MyWorkFragment mMyworkFr;
    FragmentManager fmanager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.my_fragment, container, false);

        mMywork = (TextView) rootView.findViewById(R.id.myWork);
        mMywork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mMyworkFr = new MyWorkFragment();
                fmanager = getFragmentManager();
                FragmentTransaction ftrans = fmanager.beginTransaction();
                ftrans.replace(R.id.container, mMyworkFr);
                ftrans.addToBackStack(null);
                ftrans.commit();

            }
        });


        return rootView;
    }
}
