package com.cs246.growup.Models;

import java.io.Serializable;

public class Item implements Serializable {
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