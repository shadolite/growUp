package com.cs246.growup.Presenters;

import android.os.Bundle;

import com.cs246.growup.Models.CheckBoxItem;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.EventItem;
import com.cs246.growup.Models.Item;
import com.cs246.growup.Models.NoteItem;
import com.cs246.growup.Models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BrowseEntryPresenter {
    private User user;
    private List<Item> selectedEventItems;
    private List<Item> selectedCheckBoxItems;
    private List<Item> selectedNoteItems;

    public BrowseEntryPresenter() {
        user = null;
        selectedEventItems = new ArrayList<>();
        selectedCheckBoxItems = new ArrayList<>();
        selectedNoteItems = new ArrayList<>();
    }

    public void setUser(User user) { this.user = user;}

    public void selectEntry(Date date){
        Entry entry = user.getEntry(date);
        for (Item item :
                entry.items) {
            if (item instanceof EventItem) {
                selectedEventItems.add(item);
            }
            else if (item instanceof CheckBoxItem){
                selectedCheckBoxItems.add(item);
            }
            else{
                selectedNoteItems.add(item);
            }
        }
    }

    public List<Item> getSelectedEventItems() {
        return selectedEventItems;
    }

    public List<Item> getSelectedCheckBoxItems() {
        return selectedCheckBoxItems;
    }

    public List<Item> getSelectedNoteItems() {
        return selectedNoteItems;
    }
}
