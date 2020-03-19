package com.cs246.growup.Presenters;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.Views.MainActivity;

import java.util.List;

public class MainPresenter {

    private Config config;
    private List<Goal> goals;
    private Entry entry;
    private List<Listener> registeredListeners;

    public MainPresenter(MainActivity mainActivity) {
    }

    public void registerListeners(Listener listener){

    }

    public void notifyListernersDataReady(){

    }

    public void notifyListenersDataChanged(){

    }

    public void initialize() {

    }
}