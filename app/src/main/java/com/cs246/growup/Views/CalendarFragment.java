package com.cs246.growup.Views;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import android.util.Log;
import android.widget.CalendarView;

import com.cs246.growup.Presenters.BrowseCalenderPresenter;
import com.cs246.growup.R;


public class CalendarFragment extends BrowseFragment {
    private  static final String TAG = "CalendarFragment";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        CalendarView mCalendarView = (CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView CalendarView, int year, int month, int dayOfMonth) {
                String date = year + "/" + month + "/"+ dayOfMonth ;
                Log.d(TAG, "onSelectedDayChange: yyyy/mm/dd:" + date);
                Intent intent = new Intent(CalendarFragment.this, BrowseCalenderPresenter.class);
                intent.putExtra("date",date);
                startActivity(intent);

            }
        });
    }

}
