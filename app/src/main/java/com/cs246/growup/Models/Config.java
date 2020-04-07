package com.cs246.growup.Models;

import android.content.Context;

import com.google.gson.Gson;

/**
 * Config object
 */
public class Config {

    boolean isListView;

    /**
     * Default constructor.S
     */
    public Config() {isListView = true;}

    /**
     * Sets the isListView property to true;
     */
    public void setListView() {
        isListView = true;
    }

    /**
     * Sets the isLitView property to false;
     */
    public void setCardView() {
        isListView = false;
    }

    /**
     * Reads a config object from a local file.
     * @param context Context doing the reading.
     * @return Returns a Config object.
     */
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

    /**
     * Saves the config object to a local file.
     * @param context Context saving the config file.
     */
    public void saveConfig(Context context) {

        Storage storage = new Storage(context);
        Gson gson = new Gson();
        String sConfig = gson.toJson(this);
        storage.writeFile("config.txt", sConfig);
    }
}