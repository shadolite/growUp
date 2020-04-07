package com.cs246.growup.Presenters;

import android.util.Log;

import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Library;

import java.util.ArrayList;
import java.util.List;

public class BrowsePresenter {
    private Library library;
    private Entry selectedEntry;
    private String selectedGoal;

    private List<String> validEntry;
    private List<String> validGoal;


    public BrowsePresenter() {
        library = null; // The library is set by the Fragment when the MainPresenter sends notification that the data is ready.
        selectedEntry = null;
        selectedGoal = null;

        validGoal = new ArrayList<String>();

    }

    public void setLibrary(Library library) {
        this.library = library;
    }



    public void selectGoal(String reference) {
        String[] split = reference.split(":");
        int verse = Integer.parseInt(split[1]);
        int posChapter = split[0].lastIndexOf(" ");
        String goals = split[0].substring(posChapter+1);
        String entries = split[0].substring(0,posChapter);
        Log.d("split",goals + " : " + entries);
    }

    public void selectEntry(String entry) {
        if (library == null) {
            return;
        }
        selectedEntry = (Entry) library.getEntry(entry);
        if (selectedEntry != null) {
            validGoal.clear();


        }
    }

    public void setSelectedGoal(Entry goal) {
        if (library == null) {
            return;
        }
        if (selectedEntry == null) {
            return;
        }
        selectedGoal = selectedEntry.getEntry(goal);
        if (selectedGoal != null) {

        }
    }






    public List<String> getValidEntry() {
        return library.getEntryTitles();
    }

    public List<String> getValidGoals() {
        return validGoal;
    }


}
