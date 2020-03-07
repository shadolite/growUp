package com.cs246.growup.Models;

public class Item {
    private String title;

    Item(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}