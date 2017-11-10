package com.ninefilta.ingnine.searchfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by pajh8 on 2017-11-10.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private final String tabTitles[] = new String[] {"New", "Selfie", "Daily", "Food", "Product", "Nature", "ETC"};

    public PagerAdapter(FragmentManager fm){
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return com.ninefilta.ingnine.searchfragment.NewFragment.newInstance(position);
        } else if (position == 1) {
            return com.ninefilta.ingnine.searchfragment.SelfieFragment.newInstance(position);
        } else {
            return com.ninefilta.ingnine.searchfragment.DailyFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }

}
