package com.cs246.growup.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.cs246.growup.Presenters.BrowseCalenderPresenter;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;
import com.cs246.growup.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;
//    private CollectionPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);
        presenter.initialize();

//        adapter = new CollectionPagerAdapter(getSupportFragmentManager());
//        TabLayout tabMenu = findViewById(R.id.tabLayout);
//        tabMenu.setAdapter
        setBottomNavigationListener();
        setSearchListener();
    }

    private void setSearchListener() {

    }

    private void setBottomNavigationListener() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){
                loadFragment(item.getItemId());
                return true;
            }
        };

        bottomNav.setOnNavigationItemSelectedListener(listener);
    }

    public void registerFragment(Listener fragment){
        presenter.registerListeners(fragment);
    }

    public void loadFragment(int tabID){

    }

    public void onClick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
        startActivity(intent);
    }

//    private class CollectionPagerAdapter extends FragmentPagerAdapter{
//
//        private Map<Integer, Fragment> fragments;
//
//        public CollectionPagerAdapter(FragmentManager manager){
//            super(manager);
//            fragments = new HashMap<>();
//        }
//
//        @Override
//        public Fragment getItem(int i){
//            Fragment fragment;
//
//            switch (i){
//                case 0:
//                    fragment = new BrowseEntryFragment();
//                    fragments.put(i, fragment);
//                    break;
//                case 1:
//                    fragment = new BrowseGoalFragment();
//                    fragments.put(i, fragment);
//                    break;
//                case 2:
//                    fragment = new CalendarFragment();
//                    fragments.put(i, fragment);
//                    break;
//                case 3:
//                    fragment = new SearchFragment();
//                    fragments.put(i, fragment);
//                    break;
//                case 4:
//                    fragment = new SettingsFragment();
//                    fragments.put(i, fragment);
//                    break;
//                default:
//                    fragment = null;
//            }
//
//            return fragment;
//        }
//
//        @Override
//        public  int getCount(){
//            return 5;
//        }
//
//        public  Fragment getFragment(int i){
//            return fragments.get(i);
//        }
//    }
}
