package com.example.appcopaamerica;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class PositionsFragment extends Fragment {

    private TabLayout subTabLayout;
    public ViewPager subViewPager;

    public PositionsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_positions, container, false);

        super.onCreate(savedInstanceState);

        subViewPager = (ViewPager) view.findViewById(R.id.viewsubpager);
        setupViewPager(subViewPager);

        subTabLayout = (TabLayout) view.findViewById(R.id.subtabs);
        subTabLayout.setupWithViewPager(subViewPager);

        return view;

    }


    private void setupViewPager(ViewPager viewPager) {
        MainActivity.ViewPagerAdapter adapter = new MainActivity.ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new TableFragment(), "Grupos");
        adapter.addFragment(new FaseFinalFragment(), "Fase Final");
        viewPager.setAdapter(adapter);
    }

    class ViewSubpagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewSubpagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}
