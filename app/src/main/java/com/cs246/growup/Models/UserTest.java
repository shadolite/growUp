package com.cs246.growup.Models;

import android.provider.ContactsContract;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UserTest {
    public static User getTestUser(){
        User testUser = new User();

        testUser.addGoal(getTestGoal());
        testUser.addEntry(getTestEntry());

        return testUser;
    }

    public static Goal getTestGoal(){

        Goal testGoal = new Goal();
        testGoal.setTitle("Test Goal Title");
        testGoal.setDescription("This is a test goal.");

        Calendar.getInstance().setTime(new Date());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.WEEK_OF_MONTH, 1);
        testGoal.setDueDate(cal.getTime());

        testGoal.addTag(Tag.Physical);

        testGoal.addItem(getTestNoteItem());

        return testGoal;
    }

    public static Entry getTestEntry(){
        Entry testEntry = new Entry();

        testEntry.setTitle("Test Entry Title");
        testEntry.add(getTestCheckBoxItem());
        testEntry.add(getTestEventItem());
        testEntry.add(getTestNoteItem());

        return testEntry;
    }

    private static Item getTestNoteItem() {
        NoteItem testNoteItem = new NoteItem("Test Note Item Title");

        testNoteItem.setBody("This is a test note.");

        return testNoteItem;
    }

    private static Item getTestEventItem() {
        EventItem testEventItem = new EventItem("Test Event Item");

        testEventItem.setStartTime(Calendar.getInstance().getTime());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 1);
        Date endDate = cal.getTime();
        testEventItem.setEndTime(endDate);

        return testEventItem;
    }

    private static Item getTestCheckBoxItem() {
        CheckBoxItem testCheckBoxItem = new CheckBoxItem("Test CheckBox Title");
        return testCheckBoxItem;
    }
}
