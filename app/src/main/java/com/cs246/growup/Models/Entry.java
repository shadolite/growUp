package com.cs246.growup.Models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Entry {
    public List <Item> entries;
    public GregorianCalendar entryDate;

    public Entry() {
        entries = new ArrayList<Item>();
        entryDate = (GregorianCalendar) Calendar.getInstance();
    }

    public Entry(GregorianCalendar entryDate) {
        entries = new ArrayList<Item>();
        this.entryDate = entryDate;
    }

    public void add(Item entry) {
        entries.add(entry);
    }

    public void remove(Item entry) {
        entries.remove(entry);
    }
}
