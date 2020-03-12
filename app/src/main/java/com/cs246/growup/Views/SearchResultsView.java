package com.cs246.growup.Views;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.cs246.growup.R;

public class SearchResultsView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle searched) {
        super.onCreate(searched);
        setContentView(R.layout.activity_search_view);
    }


    //only needed if we need to override the onStop() method included with AppCompatActivity
    public void onStop() {
        super.onStop();
    }
    public void notifyDataReady() {}
    public void notifyConfigChanged() {}

}
