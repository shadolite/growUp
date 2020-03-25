package com.cs246.growup.Views;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Presenters.SearchPresenter;
import com.cs246.growup.R;

public class SearchResultsView extends AppCompatActivity {
    private View rootView;
    private SearchView etSearch;
    private RecyclerView rvResults;
    private TextView tvResultsCount;
    private SearchPresenter searchPresenter;
    private Spinner spFilter;
    private GestureDetector gd;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchPresenter = new SearchPresenter();
        rootView = null;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {


            rootView = inflater.inflate(R.layout.activity_search_view, container, false);



            rvResults = rootView.findViewById(R.id.searchList);


            tvResultsCount.setText("No Results Found");
            rvResults.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));



           // ((MainActivity) getActivity()).registerFragment(this);
        }

        return rootView;
    }


    //only needed if we need to override the onStop() method included with AppCompatActivity
    public void onStop() {
        super.onStop();
    }
    public void notifyDataReady() {}
    public void notifyConfigChanged() {}

}
