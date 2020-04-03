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
import android.view.MenuItem;
import android.view.View;

import com.cs246.growup.Models.SearchData;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.BrowseCalenderPresenter;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;
import com.cs246.growup.R;
import com.cs246.growup.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements Listener {
    ActivityMainBinding bind;
    boolean isRotated = false;
    private MainPresenter presenter;
    private BrowseEntryFragment browseEntryFragment;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

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
        //setContentView(R.layout.activity_main);

        browseEntryFragment = new BrowseEntryFragment();
        presenter = new MainPresenter(this);
        presenter.initialize();



        registerFragment(browseEntryFragment);
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

    public void loadFragment(int fragmentID){

        switch (fragmentID) {
            case 0:
        }
    }

    public void onClick(MenuItem item) {
        Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
        startActivity(intent);
    }

    @Override
    public void notifyDataReady(User user, Config config) {
        /*TabLayout t = (TabLayout)findViewById(R.id.tabLayout);
        loadFragment(t.getSelectedTabPosition());
        loadFragment(0);*/

        recyclerView = (RecyclerView) findViewById(R.id.searchList);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new BrowseAdapter(browseEntryFragment.getSelectedEventItems());
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void notifyConfigChanged() {

    }
}
