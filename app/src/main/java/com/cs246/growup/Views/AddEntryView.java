package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.cs246.growup.Presenters.AddEntryPresenter;
import com.cs246.growup.R;
import com.cs246.growup.databinding.ActivityAddEntryViewBinding;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Activity for adding an entry item.
 */
public class AddEntryView extends AppCompatActivity {
    ActivityAddEntryViewBinding bind;
    private AddEntryPresenter presenter;

    /**
     * Initializes data for the Activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AddEntryPresenter();
        bind = DataBindingUtil.setContentView(this, R.layout.activity_add_entry_view);
        bind.entryDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "New Entry discarded", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bind.entrySaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveEntry();
            }
        });
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
     * Saves the user input as a goal, and calls finish() on the Activity.
     */
    public void saveEntry() {
        Intent addEntry = new Intent();
        EditText entryTitle = (EditText) bind.entryTitle;
        String title = entryTitle.getText().toString();
        EditText entryNote = (EditText) bind.entryNote;
        String note = entryNote.getText().toString();
        presenter.entry.setTitle(title);
        presenter.entry.setNote(note);
        addEntry.putExtra("Entry", presenter.getEntry());
        setResult(RESULT_OK, addEntry);
        Toast.makeText(getBaseContext(), "New Entry added", Toast.LENGTH_SHORT).show();
        finish();
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
