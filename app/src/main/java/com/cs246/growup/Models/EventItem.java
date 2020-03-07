package com.cs246.growup.Models;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class EventItem extends Item {
    public Calendar startTime;
    public Calendar endTime;

    public EventItem() {
        startTime = new GregorianCalendar();
        endTime = new GregorianCalendar();
    }

    public Calendar getStartTime() {
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
    }
}
