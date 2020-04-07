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
    private FileHelper fileHelper;

    public Library(Context context) {
        entries = new ArrayList<Entry>();
        gson = new Gson();
        fileHelper = new FileHelper(context);
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