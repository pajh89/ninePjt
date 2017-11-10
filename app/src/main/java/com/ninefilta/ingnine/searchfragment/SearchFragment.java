package com.ninefilta.ingnine.searchfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;
import com.ninefilta.ingnine.R;

/**
 * Created by pajh8 on 2017-09-27.
 */

public class SearchFragment extends Fragment {

    private ViewPager viewPager;
    private PagerSlidingTabStrip tabStrip;
    private LinearLayout mTabsLinearLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.search_fragment, container, false);


        viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        viewPager.setAdapter(new PagerAdapter(getFragmentManager()));
        tabStrip = (PagerSlidingTabStrip) rootView.findViewById(R.id.tabs);
        tabStrip.setUnderlineColor(Color.rgb(206, 206, 206));
        tabStrip.setUnderlineHeight(2);
        tabStrip.setIndicatorColor(Color.rgb(0, 88, 206));
        tabStrip.setIndicatorHeight(10);
        tabStrip.setTabPaddingLeftRight(80);
        tabStrip.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabsLinearLayout = ((LinearLayout)tabStrip.getChildAt(0));
                for(int i=0; i < mTabsLinearLayout.getChildCount(); i++){
                    TextView tv = (TextView) mTabsLinearLayout.getChildAt(i);
                    if(i == position){
                        tv.setTextColor(Color.rgb(0, 88, 206));
                    } else {
                        tv.setTextColor(Color.rgb(160,160,160));
                    }
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabStrip.setViewPager(viewPager);
        setUpTabStrip();
        return rootView;
    }

    public void setUpTabStrip(){
        mTabsLinearLayout = ((LinearLayout)tabStrip.getChildAt(0));
        for(int i=0; i < mTabsLinearLayout.getChildCount(); i++) {
            TextView tv = (TextView) mTabsLinearLayout.getChildAt(i);

            if (i == 0) {
                tv.setTextColor(Color.rgb(0, 88, 206));
            } else {
                tv.setTextColor(Color.rgb(160, 160, 160));
            }
        }}
}
