package com.cs246.growup.Models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class EventItem extends Item {
    //private Calendar startTime;
    //private Calendar endTime;
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public EventItem(String title) {
        super(title);
        //startTime = new GregorianCalendar();
        //endTime = new GregorianCalendar();
    }

    /*public Calendar getStartTime() {
        return startTime;
    }

    public void setStartTime(Calendar startTime) {
        this.startTime = startTime;
    }

    public Calendar getEndTime() {
        return endTime;
    }

    public void setEndTime(Calendar endTime) {
        this.endTime = endTime;
    }*/
}
