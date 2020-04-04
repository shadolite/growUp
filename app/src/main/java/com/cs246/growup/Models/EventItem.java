package com.cs246.growup.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventItem extends Item {
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public String getStringStartTime(){
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.format(startTime);
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getStringEndTime(){
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.format(endTime);
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public EventItem(String title) {
        super(title);
    }

    public String getEventTimePeriod(){
        return String.format(
                "%1$s to %2$s",
                /*1*/ getStringStartTime(),
                /*2*/ getStringEndTime()
        );
    }
}
