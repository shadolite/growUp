package com.cs246.growup.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ToggleButton;
import androidx.appcompat.widget.Toolbar;

import com.cs246.growup.R;

public class AddGoalView extends AppCompatActivity {

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal_view);
        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }*/


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