package com.cs246.growup.Models;

import java.io.Serializable;

/**
 * Item object
 */
public class Item implements Serializable {
    private String title;

    /**
     * Non-default constructor
     * @param title Title of the item.
     */
    Item(String title) {
        this.title = title;
    }

    /**
     * Gets the title of the item.
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title for the item.
     * @param title String to set the title as.
     */
    public void setTitle(String title) {
        this.title = title;
    }
}