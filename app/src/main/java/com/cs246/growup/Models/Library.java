package com.cs246.growup.Models;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Entry> entries;
    private Gson gson;
    private HTTPHelper httpHelper;
    private FileHelper fileHelper;

    public Library(Context context) {
        entries = new ArrayList<Entry>();
        gson = new Gson();
        httpHelper = new HTTPHelper();
        fileHelper = new FileHelper(context);
    }

    public void loadVolume(String title, String url, boolean hasBooks) {
        Log.d("Library", "Attempting to read " + title + " from file");
        String data = fileHelper.readFile(title);
        if (data == null) {
            Log.d("Library", "Attempting to read " + title + " from network");
            data = httpHelper.readHTTP(url);
        }
        Entry entry = null;
        if (hasBooks) {
            try {
                entry = gson.fromJson(data, Entry.class);
            } catch (JsonSyntaxException jse) { // Redownload if the JSON file is corrupted
                data = httpHelper.readHTTP(url);
                entry = gson.fromJson(data, Entry.class);
            }
        } else {
            Goal goal = null;
            try {
                goal = gson.fromJson(data, Goal.class);
            } catch (JsonSyntaxException jse) {
                data = httpHelper.readHTTP(url);
                goal = gson.fromJson(data, Goal.class);
            }
            if (goal != null) {
                entry = new Entry();
                entry.setTitle(title);
                //entry.getGoals().add(goal);
            }
        }
        if (entry != null) {
            Log.d("Library", "Writing " + title + " to file");
            fileHelper.writeFile(title, data);
            entry.setTitle(title);
            entries.add(entry);
        } else {
            Log.d("Library", "Error converting " + title + " from JSON");
        }
    }

    public List<Entry> getEntry(String entry) {
        return entries;
    }

    public Entry getVolume(String title) {
        for (Entry entry : entries) {
            if (entry.getEntry(entry).toUpperCase().equals(title.toUpperCase())) {
                return entry;
            }
        }
        return null;
    }

    public List<String> getEntryTitles() {
        List<String> titles = new ArrayList<String>();
        for (Entry entry : entries) {
            titles.add(entry.getEntry(entry));
        }
        return titles;
    }
}