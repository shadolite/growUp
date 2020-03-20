package com.cs246.growup.Models;

public class SearchData {
    private Entry entry;
    private Goal goal;


    public SearchData(Entry entry, Goal goal) {
        this.entry = entry;
        this.goal = goal;
    }

    public Entry getEntry() {
        return entry;
    }

    public Goal getGoal() {
        return goal;
    }

}
