package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import com.cs246.growup.R;

public class AddGoalView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_goal_view);
        final ToggleButton buttonSpiritualTag = findViewById(R.id.spiritual_tag);
        buttonSpiritualTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonSpiritualTag.setBackgroundColor(getResources().getColor(R.color.colorSpiritualTag));
                buttonSpiritualTag.setTextColor(getResources().getColor(R.color.white));
            }
        });

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