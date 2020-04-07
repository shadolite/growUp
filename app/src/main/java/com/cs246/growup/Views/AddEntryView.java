package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import com.cs246.growup.R;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;

/**
 * Activity for adding an entry item.
 */
public class AddEntryView extends AppCompatActivity {

    /**
     * Initializes data for the Activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry_view);
//        textview.setMovementMethod(new ScrollingMovementMethod());
    }

    /**
     * Inflates options menu
     * @param menu Menu to inflate.
     * @return Returns true;
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Runs processes before stopping activity.
     */
    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * Loads the data into the activity.
     */
    public void notifyDataReady(){}

    /**
     * Loads config data into the activity.
     */
    public void notifyConfigChanged(){}
}
