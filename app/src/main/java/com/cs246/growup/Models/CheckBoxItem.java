package com.cs246.growup.Models;

/**
 * CheckBoxItem object
 */
public class CheckBoxItem extends Item {
    private boolean isComplete;

    /**
     * Constructor
     * @param title Title of the item.
     */
    public CheckBoxItem(String title) {
        super(title);
        isComplete = false;
    }

    /**
     * Getter for isComplete property.
     * @return Returns the isComplete boolean.
     */
    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Setter for the isComplete property.
     * @param complete boolean used to set isComplete.
     */
    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}