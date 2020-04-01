package com.cs246.growup.Views;

import android.os.Build;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Library;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.SearchPresenter;
import com.cs246.growup.R;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view);


    }

    public class SearchFragment extends Fragment {
        private View rootView;
        private SearchView etSearch;
        private RecyclerView rvResults;
        private TextView tvResultsCount;
        private SearchPresenter searchPresenter;
        private Spinner spFilter;
        private GestureDetector gd;


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            searchPresenter = new SearchPresenter();
            rootView = null;
        }

        //only needed if we need to override the onStop() method included with AppCompatActivity
        public void onStop() {
            super.onStop();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (rootView == null) { // If null, then this is the first loading the fragment

                // Inflate the layout file
                rootView = inflater.inflate(R.layout.fragment_search, container, false);

                // Create layout objects for later use
                etSearch = rootView.findViewById(R.id.tv_search_term);
                spFilter = rootView.findViewById(R.id.sp_search_filter);
                tvResultsCount = rootView.findViewById(R.id.tv_result_count);
                rvResults = rootView.findViewById(R.id.rv_favorite_results);

                // Initialize layout object values
                tvResultsCount.setText("0 Scripture(s) Found");
                rvResults.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));

                // Register with the MainPresenter via the MainActivity to be notified of library
                // and config data

                ((MainActivity) getActivity()).registerFragment((Listener) this);
            }

            return rootView;
        }
    }
}

