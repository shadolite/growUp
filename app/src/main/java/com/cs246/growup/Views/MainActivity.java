package com.cs246.growup.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Adapters.BrowseCheckBoxAdapter;
import com.cs246.growup.Adapters.BrowseEventAdapter;
import com.cs246.growup.Adapters.BrowseNoteAdapter;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Goal;
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

/**
 * Main Activity class.
 */
public class MainActivity extends AppCompatActivity implements Listener {

    ActivityMainBinding bind;
    boolean isRotated = false;
    private MainPresenter presenter;
    private RecyclerView.Adapter recyclerViewAdapter;

    /**
     * Initializes necessary data to run the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SetFloatingActionButtonListeners();

        Date entryDate = Calendar.getInstance().getTime();
        setDateText(entryDate);

        presenter = new MainPresenter(this);
        presenter.initialize();
        presenter.setSelectedDate(entryDate);
        presenter.selectEntry();

        setBottomNavigationListener();
        setTabLayoutListeners();
    }

    /**
     * Sets the listeners for the Floating Action Button.
     */
    private void SetFloatingActionButtonListeners() {
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
                startActivityForResult(new Intent(getApplicationContext(), AddGoalView.class), 200);
            }
        });

        bind.fabAddEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentEntry = new Intent(MainActivity.this, AddEntryView.class);
                startActivity(intentEntry);
            }
        });
    }

    /**
     * Sets the date text of the main display.
     * @param entryDate Date to convert to text.
     */
    private void setDateText(Date entryDate) {
        TextView theDate = (TextView) findViewById(R.id.currentDate);
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        String strDate = dateFormat.format(entryDate);

        theDate.setText(strDate);
    }

    /**
     * Event handler for child activities passing data back to the main activity.
     * @param requestCode Indicates what data is being passed back.
     * @param resultCode Result of the child activity.
     * @param intent Intent to retrieve the information from.
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 200 && resultCode == RESULT_OK) {
            Goal goal = (Goal) intent.getSerializableExtra("Goal");
            presenter.getUser().addGoal(goal);
        }

        if (requestCode == 123 && resultCode == RESULT_OK) {
            int year = (int)intent.getIntExtra("year", 0);
            int month = (int)intent.getIntExtra("month", 0);
            int dayOfMonth = (int)intent.getIntExtra("dayOfMonth", 0);
            Calendar c = Calendar.getInstance();
            c.set(year, month, dayOfMonth, 0, 0);
            Date date = c.getTime();
            presenter.setSelectedDate(date);
        }
    }

    /**
     * Sets the listeners for the tab layout.
     */
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

    /**
     * Inflates menu options.
     * @param menu Menu to inflate.
     * @return Returns true.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Event handler for menu item selection.
     * @param item Item that was selected.
     * @return Returns true.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Fragment fragment;

        switch (item.getItemId()) {
            case R.id.menu_search:
                Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show();
                Intent intentSearch = new Intent(MainActivity.this, SearchResultsView.class);
                startActivity(intentSearch);
                break;

            case R.id.dropdown_menu:
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        return true;
    }

    /**
     * Sets the listener for the bottom navigation bar.
     */
    private void setBottomNavigationListener() {

        BottomNavigationView bottomNav = findViewById(R.id.bottomNavigationView);
        BottomNavigationView.OnNavigationItemSelectedListener listener = item -> true;
        bottomNav.setOnNavigationItemSelectedListener(listener);
    }

    /**
     * Registers a fragment as a listener.
     * @param fragment Fragment to register.
     */
    public void registerFragment(Listener fragment){
        presenter.registerListeners(fragment);
    }

    /**
     * Event handler for selecting the calendar button from the bottom navigation bar.
     * @param item Menu item that was selected.
     */
    public void calendar_OnClick(MenuItem item) {
        startActivityForResult(new Intent(getApplicationContext(), CalendarActivity.class), 123);
    }

    /**
     * Event handler for selecting the goal button from the bottom navigation bar.
     * @param item Menu item that was selected.
     */
    public void goals_OnClick(MenuItem item) {
        Intent goalsIntent = new Intent(MainActivity.this, BrowseGoalsView.class);
        goalsIntent.putExtra("User", presenter.getUser());
        startActivity(goalsIntent);
    }

    /**
     * Loads the updated data from the presenter into the main activity.
     * @param user User containing updated data to load.
     * @param config Updated config info to load.
     */
    @Override
    public void notifyDataReady(User user, Config config) {
        loadRecyclerView();
        setDateText(presenter.getSelectedDate());
    }

    /**
     * Loads data into the recycler view.
     */
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

    /**
     * Loads updated config data into the main activity.
     */
    @Override
    public void notifyConfigChanged() {

    }
}
