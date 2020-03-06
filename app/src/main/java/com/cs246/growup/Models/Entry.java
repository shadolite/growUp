package com.cs246.growup.Models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Entry {
    public void getDateTime(){
        Calendar calendar = new GregorianCalendar();
        Date entryDate = new Date();
        calendar.setTime(entryDate);
    }
    public List <Item> entries;
}
