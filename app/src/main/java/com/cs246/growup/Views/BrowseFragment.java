package com.cs246.growup.Views;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Library;
import com.cs246.growup.Models.SearchData;
import com.cs246.growup.Presenters.BrowsePresenter;
import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;
import com.cs246.growup.R;

public class BrowseFragment extends Fragment /*implements MainPresenter*/ {
    private View rootView;


    private RecyclerView rvEntry;
    private RecyclerView rvGoal;

    private BrowsePresenter browsePresenter;
    // TODO: Save the Adapters to simplify the code below

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        browsePresenter = new BrowsePresenter();
        rootView = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_browse, container, false);

            rvEntry = rootView.findViewById(R.id.rv_entry);
            rvGoal = rootView.findViewById(R.id.rv_book);

            rvEntry.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false));
            rvGoal.setLayoutManager(new LinearLayoutManager(rootView.getContext(), LinearLayoutManager.HORIZONTAL, false));

            ((MainActivity) getActivity()).registerFragment((Listener) this);
        }

        return rootView;
    }


    public void notifyDataReady(Library library, Config config) {
        browsePresenter.setLibrary(library);

        rvEntry.setAdapter(new ButtonAdapter(text -> {
            browsePresenter.selectEntry(text);
            updateAdapters();
            rvGoal.scrollToPosition(0);
        }, browsePresenter.getValidEntry()));

        rvGoal.setAdapter(new ButtonAdapter(text -> {
            browsePresenter.selectGoal(text);
            updateAdapters();

        }, browsePresenter.getValidGoals()));




    }




    private void updateAdapters() {
        rvEntry.getAdapter().notifyDataSetChanged();
        rvGoal.getAdapter().notifyDataSetChanged();


    }

    public void jumpToGoal(SearchData record) {
        browsePresenter.selectEntry(record.getEntry().getClass(record));
        browsePresenter.selectGoal(record.getGoal().getTitle());

        updateAdapters();



    }

}

