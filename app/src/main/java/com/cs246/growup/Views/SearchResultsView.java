package com.cs246.growup.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Library;
import com.cs246.growup.Models.SearchData;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.SearchPresenter;
import com.cs246.growup.Presenters.SearchResultsPresenter;
import com.cs246.growup.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchResultsView extends AppCompatActivity {

    private View rootView;
    private SearchView etSearch;
    private RecyclerView rvResults;
    private TextView tvResultsCount;
    private SearchPresenter searchPresenter;
    private Spinner spFilter;
    private GestureDetector gd;
    // TODO: Save the Adapters to simplify the code below


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchPresenter = new SearchPresenter();
        rootView = null;



    }

    public static class SearchFragment extends Fragment {
        private View rootView;
        private SearchView etSearch;
        private RecyclerView rvResults;
        private TextView tvResultsCount;
        private SearchResultsPresenter searchResultsPresenter;
        private Spinner spFilter;
        private GestureDetector gd;



        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            searchResultsPresenter = new SearchResultsPresenter();
            rootView = null;
        }


        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (rootView == null) {


                rootView = inflater.inflate(R.layout.fragment_search, container, false);


                etSearch = rootView.findViewById(R.id.tv_search_term);
                spFilter = rootView.findViewById(R.id.sp_search_filter);
                tvResultsCount = rootView.findViewById(R.id.tv_result_count);
                rvResults = rootView.findViewById(R.id.rv_favorite_results);


                tvResultsCount.setText("No Item Found");
                rvResults.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.VERTICAL, false));



                ((MainActivity) Objects.requireNonNull(getActivity())).registerFragment((Listener) this);
            }

            return rootView;
        }



        public void notifyDataReady(Library library, Config config) {
            searchResultsPresenter.setLibrary(library);



            rvResults.setAdapter(new SearchAdapter(SearchResultsPresenter.getSearchResults(), config));


            List<String> filterOptions = new ArrayList<String>();
            filterOptions.add("All Goals");
            filterOptions.addAll(searchResultsPresenter.getEntryTitles());
            spFilter.setAdapter(new ArrayAdapter<String>(Objects.requireNonNull(getContext()), android.R.layout.simple_spinner_item, filterOptions));


            spFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    updateSearchResults();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });


            etSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextChange(String s) {
                    updateSearchResults();
                    return false;
                }

                @Override
                public boolean onQueryTextSubmit(String s) {
                    updateSearchResults();
                    return false;
                }
            });


            gd = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onDoubleTapEvent(MotionEvent e) {
                    if (e.getAction() == MotionEvent.ACTION_UP) {
                        View child = rvResults.findChildViewUnder(e.getX(), e.getY());
                        assert child != null;
                        int position = rvResults.getChildAdapterPosition(child);
                        SearchData record = SearchResultsPresenter.getSearchResults().getData().get(position);
                        //((MainActivity) Objects.requireNonNull(getActivity())).loadFragment(record);
                    }
                    return super.onDoubleTapEvent(e);
                }
            });
            rvResults.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
                @Override
                public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
                    gd.onTouchEvent(motionEvent);
                    return false;
                }

                @Override
                public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

                }

                @Override
                public void onRequestDisallowInterceptTouchEvent(boolean b) {

                }
            });
        }



        public void notifyConfigChanged() {
            Objects.requireNonNull(rvResults.getAdapter()).notifyDataSetChanged();
        }


        @SuppressLint("SetTextI18n")
        private void updateSearchResults() {
            String volumeFilter = (String) spFilter.getSelectedItem();
            if (volumeFilter.equals("All Goals")) {
                volumeFilter = null;
            }
            searchResultsPresenter.searchTerm(etSearch.getQuery().toString(), volumeFilter);
            Objects.requireNonNull(rvResults.getAdapter()).notifyDataSetChanged();
            tvResultsCount.setText(SearchResultsPresenter.getSearchResults().getData().size() + " No search found");

        }


    }
}
