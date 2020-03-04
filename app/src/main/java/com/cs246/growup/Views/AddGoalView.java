package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cs246.growup.R;

public class AddGoalView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal_view);
    }

    @Override
    public void onStop() {
        super.onStop();
    }
    public void notifyDataReady(){}
    public void notifyConfigChanged(){}
    public void addTags(){}
    public void addTitle(){}
    public void addDescription(){}
}