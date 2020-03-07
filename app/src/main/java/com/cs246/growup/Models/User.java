package com.cs246.growup.Models;

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
}
