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

/**
 * Presenter for the MainActivity class.
 */
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

    /**
     * Constructor.
     * @param mainActivity Activity belonging to the presenter.
     */
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

    /**
     * Initializes the data for the presenter.
     */
    public void initialize() {

        config = Config.readConfig(context);
        LoadUserTask loadUserTask = new LoadUserTask(this);
        loadUserTask.execute();
    }

    /**
     * Registers a listener for the presenter.
     * @param listener Listener to register.
     */
    public void registerListeners(Listener listener){

        registeredListeners.add(listener);
        if (userReady) {
            listener.notifyDataReady(user, config);
        }
    }

    /**
     * Notifies all listeners that data is ready to be loaded.
     */
    public void notifyListenersDataReady(){

        userReady = true;
        for (Listener listener : registeredListeners) {
            listener.notifyDataReady(user, config);
        }
    }

    /**
     * Notifies all listeners that config information has been updated.
     */
    public void notifyListenersConfigChanged(){

        for (Listener listener : registeredListeners) {
            listener.notifyConfigChanged();
        }
    }

    /**
     * Loads the user.
     */
    public void loadUser(){
        user = user.readUser(context);
    }

    /**
     * Saves the user.
     */
    public void saveUser(){
        user.saveUser(context);
    }

    /**
     * Gets the config object.
     * @return Returns the config object from the presenter.
     */
    public Config getConfig() {
        return config;
    }

    /**
     * Gets the user object.
     * @return Returns the user object from the presenter.
     */
    public User getUser() {
        return user;
    }

    /**
     * Gets the context.
     * @return Returns the context object from the presenter.
     */
    public Context getContext() {
        return context;
    }

    /**
     * Sets all selected information based on the selected date.
     */
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

    /**
     * Gets the selected event items.
     * @return Returns a list of item objects.
     */
    public List<Item> getSelectedEventItems() {
        return selectedEventItems;
    }

    /**
     * Gets the selected checkbox items.
     * @return Returns a list of item objects.
     */
    public List<Item> getSelectedCheckBoxItems() {
        return selectedCheckBoxItems;
    }

    /**
     * Gets the selected note items.
     * @return Returns a list of Item objects.
     */
    public List<Item> getSelectedNoteItems() {
        return selectedNoteItems;
    }

    /**
     * Sets the selected date.
     * @param date Date to set as the selectedDate.
     */
    public void setSelectedDate(Date date) {
        selectedDate = date;
        selectEntry();
    }

    /**
     * Gets the selected date from the presenter.
     * @return Returns the selected date as a Date object.
     */
    public Date getSelectedDate() {
        return selectedDate;
    }
}