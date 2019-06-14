package com.example.appcopaamerica;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class SubpageAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public SubpageAdapter(FragmentManager fm) {
        super(fm);
    }

    public SubpageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                TableFragment table_frag = new TableFragment();
                return table_frag;
            case 1:
                FaseFinalFragment faseFinal_frag = new FaseFinalFragment();
                return faseFinal_frag;
            default:
                TableFragment table_fragm = new TableFragment();
                return table_fragm;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
