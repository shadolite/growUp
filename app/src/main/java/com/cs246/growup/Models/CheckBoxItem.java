package com.cs246.growup.Models;

public class CheckBoxItem extends Item {
    private boolean isComplete;

    public CheckBoxItem(String title) {
        super(title);
        isComplete = false;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }
}
