package com.cs246.growup.Models;

import java.util.ArrayList;
import java.util.List;

/**
 * Creates a list of Results
 */

 public class SearchResult {
    private List<SearchData> data;
    private String searchTerm;

    /**
     * Fetch the data
     */
    public SearchResult() {
        data = new ArrayList<>();
        searchTerm = "";
    }

    /**
     * Clear data
     */
    public void clear() {
        data.clear();
        searchTerm = "";
    }

    /**
     * Add entry and goal
     * @param entry
     * @param goal
     */
    public void add(Entry entry, Goal goal) {
        SearchData record = new SearchData(entry, goal);
        data.add(record);
    }

    /**
     * Gets the data
     * @return
     */
    public List<SearchData> getData() {
        return data;
    }

    /**
     * set the data
     * @param data
     */
    public void setData(List<SearchData> data) {
        this.data = data;
    }

    /**
     * gets term
     * @return
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

}