package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cs246.growup.R;

public class BrowseGoalsView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_goals_view);
    }

    public void notifyDataReady() {
    }
}
