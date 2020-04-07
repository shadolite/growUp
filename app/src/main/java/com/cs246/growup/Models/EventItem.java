package com.cs246.growup.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * EventItem object.
 */
public class EventItem extends Item {

    private Date startTime;
    private Date endTime;

    /**
     * Non-default constructor.
     * @param title Title for the event item.
     */
    public EventItem(String title) {
        super(title);
    }

    /**
     * Gets the start time for the event.
     * @return Returns the start time as a Date object.
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * Gets the start time as a string.
     * @return Returns the start time as a String.
     */
    public String getStringStartTime(){
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.format(startTime);
    }

    /**
     * Sets the start time for the event.
     * @param startTime Time to set as the start time.
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * Gets the end time for the event.
     * @return Returns the end time as a Date object.
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * Gets the end time as a string.
     * @return Returns the end time as a String.
     */
    public String getStringEndTime(){
        DateFormat dateFormat = new SimpleDateFormat("h:mm a");

        return dateFormat.format(endTime);
    }

    /**
     * Sets the end time for the event.
     * @param endTime Time to set as the end time.
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * Gets the time period for the event in a String format.
     * @return Returns the time period as a string.
     */
    public String getEventTimePeriod(){
        return String.format(
                "%1$s to %2$s",
                getStringStartTime(),
                getStringEndTime()
        );
    }
}