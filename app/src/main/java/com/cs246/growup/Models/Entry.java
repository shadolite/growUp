package com.cs246.growup.Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Entry {
    public List <Item> items;
    public Date entryDate;
    //public GregorianCalendar entryDate;
    private String title;

    public Entry() {
        items = new ArrayList<Item>();
        Calendar cal = new GregorianCalendar();
        cal.setTime(new Date());
        entryDate = cal.getTime();
    }

    public Entry(Date date) {
        items = new ArrayList<Item>();
        this.entryDate = date;
    }

    public void add(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        items.remove(item);
    }
    public String getEntry() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
