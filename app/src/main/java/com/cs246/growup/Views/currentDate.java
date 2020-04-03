package com.cs246.growup.Views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.cs246.growup.R;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class currentDate extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView theDate = (TextView) findViewById(R.id.currentDate);

        Intent incoming = getIntent();
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        Date entryDate = cal.getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

        String strDate = dateFormat.format(entryDate);

        theDate.setText(strDate);
    }
}
