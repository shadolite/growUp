package com.cs246.growup.Models;

import android.content.Context;

import com.google.gson.Gson;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User object
 */
public class User implements Serializable {
    private List<Goal> goals;
    private List<Entry> entries;

    /**
     * Default constructor.
     */
    public User() {
        goals = new ArrayList<>();
        entries = new ArrayList<>();
    }

    /**
     * Adds a goal to the list of goals for the user.
     * @param goal Goal object to add.
     */
    public void addGoal(Goal goal){
        goals.add(goal);
    }

    /**
     * Adds an entry to the list of entries for the user.
     * @param entry Entry object to add.
     */
    public void addEntry(Entry entry){
        entries.add(entry);
    }

    /**
     * Removes a goal from the list of user goals.
     * @param goal Goal to remove.
     */
    public void removeGoal(Goal goal){
        goals.remove(goal);
    }

    /**
     * Removes an entry from the list of user entries.
     * @param entry Entry to remove.
     */
    public void removeEntry(Entry entry){
        entries.remove(entry);
    }

    /**
     * Reads the user object from the save file.
     * @param context Context doing the reading.
     * @return Returns a user object.
     */
    public static User readUser(Context context) {

        Storage storage = new Storage(context);
        String sUser = storage.readFile("user.txt");
        Gson gson = new Gson();
        User user = gson.fromJson(sUser, User.class);
        if (user == null) {
            user = UserTest.getTestUser();
        }
        return user;
    }

    /**
     * Saves the user object into a save file.
     * @param context Context doing the saving.
     */
    public void saveUser(Context context) {

        Storage storage = new Storage(context);
        Gson gson = new Gson();
        String sUser = gson.toJson(this);
        storage.writeFile("user.txt", sUser);
    }

    /**
     * Gets the entry belonging to a specific date.
     * @param date Date to search for.
     * @return Returns an Entry object.
     */
    public Entry getEntry(Date date) {

        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
        String strDate = dateFormat.format(date);

        for (Entry entry : entries
                ) {
            String d2 = dateFormat.format(entry.entryDate);
            if (strDate.contains(d2)){
                return entry;
            }
        }

        return new Entry();
    }

    /**
     * Gets all goals for the user.
     * @return Returns a list of Goal objects.
     */
    public List<Goal> getGoals() {
        return goals;
    }
}