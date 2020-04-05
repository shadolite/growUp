package com.cs246.growup.Views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.CalendarView;
import android.widget.Toast;

import com.cs246.growup.Presenters.BrowseCalenderPresenter;
import com.cs246.growup.R;

public class CalendarActivity extends AppCompatActivity {

    private static final String TAG = "CalendarFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        CalendarView mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                Intent intent = new Intent();
                intent.putExtra("year", year);
                intent.putExtra("month", month);
                intent.putExtra("dayOfMonth", dayOfMonth);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

}