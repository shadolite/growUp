package com.cs246.growup.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.cs246.growup.Adapters.BrowseCheckBoxAdapter;
import com.cs246.growup.Adapters.BrowseEventAdapter;
import com.cs246.growup.Adapters.BrowseNoteAdapter;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.SearchData;
import com.cs246.growup.Models.SearchResult;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;
import com.cs246.growup.R;
import com.cs246.growup.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Listener {
    ActivityMainBinding bind;
    boolean isRotated = false;
    private MainPresenter presenter;
    private RecyclerView.Adapter recyclerViewAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_main);

        bind.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isRotated = Animations.rotateFabAdd(v, !isRotated);
            }
        });

        Animations.initial(bind.fabAddGoal);
        Animations.initial(bind.fabAddEntry);

        bind.floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                isRotated = Animations.rotateFabAdd(v, !isRotated);
                if(isRotated) {
                    Animations.popIn(bind.fabAddGoal);
                    Animations.popIn(bind.fabAddEntry);
                }else {
                    Animations.popOut(bind.fabAddGoal);
                    Animations.popOut(bind.fabAddEntry);
                }
            }
        });

        bind.fabAddGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGoal = new Intent(MainActivity.this, AddGoalView.class);
                startActivity(intentGoal);
            }
        });
        
        bind.fabAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEntry = new Intent(MainActivity.this, AddEntryView.class);
                startActivity(intentEntry);
            }
        });

        TextView theDate = (TextView) findViewById(R.id.currentDate);

        Date entryDate = Calendar.getInstance().getTime(); //cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        String strDate = dateFormat.format(entryDate);

        theDate.setText(strDate);

        presenter = new MainPresenter(this);
        presenter.initialize();
        presenter.setSelectedDate(entryDate);
        presenter.selectEntry();

        setBottomNavigationListener();
        setSearchListener();

        setTabLayoutListeners();
    }

    private void setTabLayoutListeners() {
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab){
                loadRecyclerView();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab){ }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        class CollectionPagerAdapter extends FragmentPagerAdapter {

            public Fragment getFragment(int i) {
                return fragments.get(i);
            }

            private Map<Integer, Fragment> fragments;

            public CollectionPagerAdapter(FragmentManager fm) {
                super(fm);
                fragments = new HashMap<>();
            }


            @Override
            public Fragment getItem(int i) {
                Fragment fragment;

                switch(i) {
                    case 0:
                        fragment = new BrowseFragment();
                        fragments.put(i, fragment);
                        break;
                    case 1:
                        fragment = new SearchResultsView.SearchFragment();
                        fragments.put(i, fragment);
                        break;
                    case 2:
                        fragment = new SettingsFragment();
                        fragments.put(i, fragment);
                        break;

                    default:
                        fragment = null;
                }
                return fragment;
            }

            public void loadGoals(SearchData record) {

                getFragment(R.id.menu_browse);

            }

            @Override
            public int getCount() {
                return 3;
            }



        }
        return true;
    }




    private void setSearchListener() {

    }

    private void setBottomNavigationListener() {
        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);

        BottomNavigationView.OnNavigationItemSelectedListener listener = new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item){

                //loadFragment(item.getItemId());
                return true;
            }
        };

        bottomNav.setOnNavigationItemSelectedListener(listener);
    }

    public void registerFragment(Listener fragment){
        presenter.registerListeners(fragment);
    }

    public void calendar_OnClick(MenuItem item) {
        Intent calendarIntent = new Intent(MainActivity.this, CalendarActivity.class);
        startActivity(calendarIntent);
    }

    public void goals_OnClick(MenuItem item) {
        Intent goalsIntent = new Intent(MainActivity.this, BrowseGoalsView.class);
        goalsIntent.putExtra("User", presenter.getUser());
        startActivity(goalsIntent);
    }

    @Override
    public void notifyDataReady(User user, Config config) {
        loadRecyclerView();
    }

    private void loadRecyclerView() {
        RecyclerView itemRecyclerView = (RecyclerView) findViewById(R.id.searchList);

        // Create adapter passing in the sample user data
        switch(((TabLayout)findViewById(R.id.tabLayout)).getSelectedTabPosition()){
            case 0:
                recyclerViewAdapter = new BrowseEventAdapter(presenter.getSelectedEventItems());
                break;
            case 1:
                recyclerViewAdapter = new BrowseCheckBoxAdapter(presenter.getSelectedCheckBoxItems());
                break;
            case 2:
                recyclerViewAdapter = new BrowseNoteAdapter(presenter.getSelectedNoteItems());
        }

        // Attach the adapter to the recyclerview to populate items
        itemRecyclerView.setAdapter(recyclerViewAdapter);
        // Set layout manager to position the items
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void notifyConfigChanged() {

    }

    public void jumpToDate(Date date){
        presenter.setSelectedDate(date);
    }
}
