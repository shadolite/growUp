package com.cs246.growup.Presenters;

import android.content.Context;

import com.cs246.growup.Models.CheckBoxItem;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.EventItem;
import com.cs246.growup.Models.Item;
import com.cs246.growup.Models.Library;
import com.cs246.growup.Models.User;
import com.cs246.growup.Views.MainActivity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MainPresenter {

    private Config config;
    private User user;
    private Date selectedDate;
    private List<Item> selectedEventItems;
    private List<Item> selectedCheckBoxItems;
    private List<Item> selectedNoteItems;
    private boolean userReady;
    private List<Listener> registeredListeners;
    private Context context;
    private Library library;
    private boolean libraryReady;

    public MainPresenter(MainActivity mainActivity) {
        config = new Config();
        user = new User();
        selectedDate = Calendar.getInstance().getTime();
        selectedEventItems = new ArrayList<>();
        selectedCheckBoxItems = new ArrayList<>();
        selectedNoteItems = new ArrayList<>();
        userReady = false;
        context = (Context) mainActivity;
        registeredListeners = new ArrayList<Listener>();
        registerListeners(mainActivity);
    }

    public void initialize() {
        config = Config.readConfig(context);
        LoadUserTask loadUserTask = new LoadUserTask(this);
        loadUserTask.execute();
    }

    public void registerListeners(Listener listener){

        registeredListeners.add(listener);
        if (userReady) {
            listener.notifyDataReady(user, config);
        }
    }

    public void notifyListenersDataReady(){

        userReady = true;
        for (Listener listener : registeredListeners) {
            listener.notifyDataReady(user, config);
        }
    }

    public void notifyListenersConfigChanged(){

        for (Listener listener : registeredListeners) {
            listener.notifyConfigChanged();
        }
    }

    public void loadUser(){
        user = user.readUser(context);
    }

    public void saveUser(){
        user.saveUser(context);
    }

    public Config getConfig() {
        return config;
    }

    public User getUser() {
        return user;
    }

    public Context getContext() {
        return context;
    }

    public void selectEntry(){

        Entry entry = user.getEntry(selectedDate);

        selectedNoteItems.clear();
        selectedCheckBoxItems.clear();
        selectedNoteItems.clear();

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
        notifyListenersDataReady();
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

    public void setSelectedDate(Date date) {
        selectedDate = date;
        selectEntry();
    }
    public Library getLibrary() {
        return library;
    }


    public Date getSelectedDate() {
        return selectedDate;
    }
}