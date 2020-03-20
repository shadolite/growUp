package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import com.cs246.growup.R;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;

public class AddEntryView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry_view);
//        textview.setMovementMethod(new ScrollingMovementMethod());
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public void notifyDataReady(){}
    public void notifyConfigChanged(){}
}
