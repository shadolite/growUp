package com.cs246.growup.Presenters;

import android.content.Context;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.Storage;
import com.cs246.growup.Models.User;
import com.cs246.growup.Views.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter {

    private Config config;
    private User user;
    private boolean userReady;
    private List<Listener> registeredListeners;
    private Context context;

    public MainPresenter(MainActivity mainActivity) {
        user = new User();
        userReady = false;
        context = (Context) mainActivity;
        registeredListeners = new ArrayList<Listener>();
    }

    public void initialize() {
        // Bro. MacBeth uses task threading to handle this. How do we want to manage it? I'm pretty
        // sure it's a requirement for our project.
        config = Config.readConfig(context);
        user = user.readUser(context);
    }

    public void registerListeners(Listener listener){

        registeredListeners.add(listener);
        if (userReady) {
            listener.notifyDataReady(user, config);
        }
    }

    public void notifyListenersUserReady(){

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

    public Config getConfig() {
        return config;
    }

    public User getUser() {
        return user;
    }

    public Context getContext() {
        return context;
    }
}