package com.cs246.growup.Presenters;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.Library;
import com.cs246.growup.Models.SearchData;
import com.cs246.growup.Models.SearchResult;
import com.cs246.growup.Models.Entry;

public class SearchResultsPresenter {
    private Library library;
    private static SearchResult searchResults;
    private String prevVolumeFilter;
    private String prevTerm;
    private String entry;
    private Goal goal;

    public SearchResultsPresenter() {
        searchResults = new SearchResult();
        library = null;
        prevVolumeFilter = null;
        prevTerm = null;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }



    public void searchTerm(String term, String entryFilter) {
        if (library == null) {
            return;
        }
        if (entryFilter == null) {
            entryFilter = "";
        }
        if (prevTerm == null || term.length() < prevTerm.length() || prevVolumeFilter == null || !prevVolumeFilter.contentEquals(entryFilter)) {
            searchResults.clear();
            for (Entry entry : library.getEntry(entry)) {
                if (!entryFilter.contentEquals("") && !entryFilter.contentEquals(entry.getEntry(entry)))
                    continue;
                for (Goal goal : entry.getGoal()) {
                    searchResults.add(entry, goal);
                }
            }
        }

        else {
            List<SearchData> updateList = new ArrayList<>();
            for (SearchData record : searchResults.getData()) {

                    updateList.add(record);

            }
            searchResults.clear();
            searchResults.getData().addAll(updateList);
            Log.d("SearchPresenter","Size of SearchResults: "+searchResults.getData().size());
        }
        prevTerm = term;
        prevVolumeFilter = entryFilter;
        searchResults.setSearchTerm(term);
    }



    public static SearchResult getSearchResults() {
        return searchResults;
    }

    public List<String> getEntryTitles() {
        return library.getEntryTitles();
    }

}
