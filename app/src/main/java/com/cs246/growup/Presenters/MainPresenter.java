package com.cs246.growup.Presenters;

import com.cs246.growup.Config;
import com.cs246.growup.Entry;
import com.cs246.growup.Goal;
import com.cs246.growup.MainActivity;

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
}