package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import com.cs246.growup.R;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuInflater;

public class AddEntryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry_view);
//        textview.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public void onStop() {
        super.onStop();
    }

    public void notifyDataReady(){}
    public void notifyConfigChanged(){}
}
