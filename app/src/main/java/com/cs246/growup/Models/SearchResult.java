package com.cs246.growup.Models;

import java.util.ArrayList;
import java.util.List;

public class SearchResult {
    private List<SearchData> data;
    private String searchTerm;

    public SearchResult() {
        data = new ArrayList<>();
        searchTerm = "";
    }

    public void clear() {
        data.clear();
        searchTerm = "";
    }

    public void add(Entry entry, Goal goal) {
        SearchData record = new SearchData(entry, goal);
        data.add(record);
    }

    public List<SearchData> getData() {
        return data;
    }

    public void setData(List<SearchData> data) {
        this.data = data;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

}