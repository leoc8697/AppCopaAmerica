package com.example.appcopaamerica;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewMatch;
    private RecyclerViewAdapter adapterMatch;

    private TabLayout tabLayout;
    public ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Vinculamos nuestra instancia recycler view
        recyclerViewMatch = (RecyclerView)findViewById(R.id.recyclerMatch);
        recyclerViewMatch.setLayoutManager(new LinearLayoutManager(this));

        //Aquí asignamos toda la info de nuestro recycler view en nuestro layout
        adapterMatch= new RecyclerViewAdapter(getMatchs());
        recyclerViewMatch.setAdapter(adapterMatch);

    }

    public List<MatchModel> getMatchs(){

        List<MatchModel> match=new ArrayList<>();
        match.add(new MatchModel("Brasil", "Bolivia", "Hora", "Viernes 14 Junio",R.drawable.logo,R.drawable.logo));
        match.add(new MatchModel("Brasil2", "Bolivia2", "Hora2", "Viernes2",R.drawable.logo,R.drawable.logo));
        //match.add(new MatchModel("Brasil3", "Hora3", "Bolivia3", "Viernes3",R.drawable.br,R.drawable.bo));

        return match;
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CalendarFragment(), "calendario");
        adapter.addFragment(new PositionsFragment(), "posiciones");
        adapter.addFragment(new TeamsFragment(), "equipos");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
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
