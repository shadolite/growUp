package com.cs246.growup.Models;

import android.content.Context;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class User {
    private List<Goal> goals;
    private List<Entry> entries;

    public User() {
        goals = new ArrayList<>();
        entries = new ArrayList<>();
    }

    public void addGoal(Goal goal){
        goals.add(goal);
    }

    public void addEntry(Entry entry){
        entries.add(entry);
    }

    public void removeGoal(Goal goal){
        goals.remove(goal);
    }

    public void removeEntry(Entry entry){
        entries.remove(entry);
    }

    public static User readUser(Context context) {
        Storage storage = new Storage(context);
        String sUser = storage.readFile("user.txt");
        Gson gson = new Gson();
        User user = gson.fromJson(sUser, User.class);
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public void saveUser(Context context) {
        Storage storage = new Storage(context);
        Gson gson = new Gson();
        String sUser = gson.toJson(this);
        storage.writeFile("user.txt", sUser);

    }
}
