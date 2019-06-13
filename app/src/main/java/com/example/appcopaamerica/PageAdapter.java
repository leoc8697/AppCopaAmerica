package com.example.appcopaamerica;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PageAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PageAdapter(FragmentManager fm) {
        super(fm);
    }

    public PageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                CalendarFragment calendar_frag = new CalendarFragment();
                return calendar_frag;
            case 1:
                PositionsFragment positions_frag = new PositionsFragment();
                return positions_frag;
            case 2:
                TeamsFragment teams_frag = new TeamsFragment();
                return teams_frag;
            default:
                CalendarFragment calendar_fragm = new CalendarFragment();
                return calendar_fragm;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
