package com.cs246.growup.Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EventItem extends Item {
    public Calendar startTime(int year, int month, int dayOfMonth, int hourOfDay, int minute){

        //GregorianCalendar has a constructor that accepts year, month, dayOfMonth, hourOfDay, minute
        Calendar start = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute);
        return start;
    }
    public Calendar endTime(int year, int month, int dayOfMonth, int hourOfDay, int minute){

        //GregorianCalendar has a constructor that accepts year, month, dayOfMonth, hourOfDay, minute
        Calendar end = new GregorianCalendar(year, month, dayOfMonth, hourOfDay, minute);
        return end;
    }
}
