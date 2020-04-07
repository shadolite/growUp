package com.cs246.growup.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Goal object.
 */
public class Goal implements Serializable {

    public List <Entry> entries;
    public List <Item> items;
    public List <Tag> tags;
    @SerializedName(value="goal", alternate = {"title"})
    private String title;
    private String description;
    private Date dueDate;
    private boolean isComplete;

    /**
     * Default constructor.
     */
    public Goal() {
        entries = new ArrayList<Entry>();
        items = new ArrayList<Item>();
        tags = new ArrayList<Tag>();
        isComplete = false;
        dueDate = Calendar.getInstance().getTime();
    }

    /**
     * Gets the isComplete status of the goal.
     * @return Returns true if the goal is complete; else returns false.
     */
    public boolean isComplete() {
        return isComplete;
    }

    /**
     * Sets whether the goal is complete.
     * @param complete Boolean to assign to the isComplete property.
     */
    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    /**
     * Gets the title of the goal.
     * @return Returns the title as a string.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the goal.
     * @param title String to set as the title.
     */
    public void setTitle(String title){
        this.title = title;
    }

    /**
     * Gets the description of the goal.
     * @return Returns the description as a string.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the goal.
     * @param description String to set as the description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the due date for the goal.
     * @return Returns the due date as a Date object.
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the goal.
     * @param dueDate Date to set as the due date.
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Adds an entry to the goal.
     * @param entry Entry to add.
     */
    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    /**
     * Adds an item to the goal.
     * @param item Item to add.
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Adds a tag to the goal.
     * @param tag Tag to add.
     */
    public void addTag(Tag tag) {
        tags.add(tag);
    }

    /**
     * Removes an entry from the goal.
     * @param entry Entry to remove.
     */
    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }

    /**
     * Removes an item from the goal.
     * @param item Item to remove.
     */
    public void removeItem(Item item) {
        items.remove(item);
    }

    /**
     * Removes a tag from the goal.
     * @param tag Tag to remove.
     */
    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    /**
     * Gets the due date of the goal as a string.
     * @return Returns the due date as a String.
     */
    public String GetStringDueDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        return dateFormat.format(dueDate);
    }
}