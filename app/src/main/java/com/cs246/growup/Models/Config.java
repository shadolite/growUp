package com.cs246.growup.Models;

import android.content.Context;

import com.google.gson.Gson;

public class Config {
    boolean isListView;

    public Config() {isListView = true;}

    public void setListView() {
        isListView = true;
    }

    public void setCardView() {
        isListView = false;
    }

    public static Config readConfig(Context context) {
        Storage storage = new Storage(context);
        String sConfig = storage.readFile("config.txt");
        Gson gson = new Gson();
        Config config = gson.fromJson(sConfig, Config.class);
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public void saveConfig(Context context) {
        Storage storage = new Storage(context);
        Gson gson = new Gson();
        String sConfig = gson.toJson(this);
        storage.writeFile("config.txt", sConfig);

    }
}
