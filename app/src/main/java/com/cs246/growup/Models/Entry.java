package com.cs246.growup.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Entry object
 */
public class Entry implements Serializable {

    public List <Item> items;
    public Date entryDate;
    private String title;
    private String note;
    private Goal goal;

    /**
     * Default constructor.
     */
    public Entry() {
        items = new ArrayList<Item>();
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        entryDate = cal.getTime();
    }

    /**
     * Non-default constructor.
     * @param date Date of the entry.
     */
    public Entry(Date date) {
        items = new ArrayList<Item>();
        this.entryDate = date;
    }

    public List<Goal> getGoal() {
        return (List<Goal>) goal;
    }

    /**
     * Adds an item to the list of items in the entry.
     * @param item Item to add.
     */
    public void add(Item item) {
        items.add(item);
    }

    /**
     * Removes an item from the list of items in the entry.
     * @param item Item to remove.
     */
    public void remove(Item item) {
        items.remove(item);
    }

    /**
     * Gets the title of the entry.
     * @return Returns the title as a string.
     */
    public String getTitle() { return title; }

    /**
     * Sets the title for the entry.
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the note of the entry.
     * @return Returns the note as a string.
     */
    public String getNote() { return note; }

    /**
     * Sets the note for the entry.
     * @param note
     */
    public void setNote(String note) { this.note = note; }

    public String getClass(SearchData record) {
        return title;
    }

    public String getEntry(Entry goal) {
        return title;
    }
}