package com.cs246.growup.Presenters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.cs246.growup.R;
import com.cs246.growup.Views.CalendarFragment;

@SuppressLint("Registered")
public class BrowseCalenderPresenter extends AppCompatActivity{
    private static final String TAG = "BrowseCalendarPresenter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btngocalendar = (Button) findViewById(R.id.btngocalendar);


        btngocalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BrowseCalenderPresenter.this, CalendarFragment.class);
                startActivity(intent);
            }
        });
    }

}
