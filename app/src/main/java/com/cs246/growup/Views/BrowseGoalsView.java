package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.cs246.growup.Adapters.BrowseCheckBoxAdapter;
import com.cs246.growup.Adapters.BrowseEventAdapter;
import com.cs246.growup.Adapters.BrowseGoalAdapter;
import com.cs246.growup.Adapters.BrowseNoteAdapter;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.BrowseGoalPresenter;
import com.cs246.growup.R;
import com.google.android.material.tabs.TabLayout;

/**
 * Class for the browse goals activity.
 */
public class BrowseGoalsView extends AppCompatActivity {

    private BrowseGoalPresenter presenter;
    private RecyclerView.Adapter recyclerViewAdapter;

    /**
     * Initializes all the data for the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_goals_view);

        presenter = new BrowseGoalPresenter(this);

        User user = (User)getIntent().getSerializableExtra("User");
        presenter.initialize(user);
        setTabLayoutListeners();
    }

    /**
     * Sets listeners for the tab layout.
     */
    private void setTabLayoutListeners() {
        TabLayout tabLayout = findViewById(R.id.goalsTabLayout);
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
     * Loads data into the activity.
     */
    public void notifyDataReady() {
        loadRecyclerView();
    }

    /**
     * Loads data into the recycler view.
     */
    private void loadRecyclerView() {
        RecyclerView itemRecyclerView = (RecyclerView) findViewById(R.id.goalList);

        // Create adapter passing in the sample user data
        switch(((TabLayout)findViewById(R.id.goalsTabLayout)).getSelectedTabPosition()){
            case 0:
                recyclerViewAdapter = new BrowseGoalAdapter(presenter.getCurrentGoals());
                break;
            case 1:
                recyclerViewAdapter = new BrowseGoalAdapter(presenter.getCompletedGoals());
                break;
        }

        // Attach the adapter to the recyclerview to populate items
        itemRecyclerView.setAdapter(recyclerViewAdapter);
        // Set layout manager to position the items
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
