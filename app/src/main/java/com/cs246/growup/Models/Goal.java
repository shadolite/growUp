package com.cs246.growup.Models;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Goal {
    public List <Entry> entries;
    public List <Item> items;
    public List <Tag> tags;

    public void getDateTime(){
        Calendar calendar = new GregorianCalendar();
        Date goalDate = new Date();
        calendar.setTime(goalDate);
    }
}
