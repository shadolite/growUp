package com.cs246.growup.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Goal implements Serializable {
    public List <Entry> entries;
    public List <Item> items;
    public List <Tag> tags;
    @SerializedName(value="goal", alternate = {"title"})
    private String title;
    private String description;
    private Date dueDate;
    private boolean isComplete;

    public boolean isComplete() {
        return isComplete;
    }

    public void setComplete(boolean complete) {
        isComplete = complete;
    }

    public Goal() {
        entries = new ArrayList<Entry>();
        items = new ArrayList<Item>();
        tags = new ArrayList<Tag>();
        isComplete = false;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void addEntry(Entry entry) {
        entries.add(entry);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void addTag(Tag tag) {
        tags.add(tag);
    }

    public void removeEntry(Entry entry) {
        entries.remove(entry);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void removeTag(Tag tag) {
        tags.remove(tag);
    }

    public String GetStringDueDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");

        return dateFormat.format(dueDate);
    }
}
