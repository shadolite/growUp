package com.cs246.growup.Views;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Item;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.BrowseEntryPresenter;
import com.cs246.growup.Presenters.Listener;

import java.util.Date;
import java.util.List;

public class BrowseEntryFragment  extends Fragment implements Listener {
    private BrowseEntryPresenter browseEntryPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        browseEntryPresenter = new BrowseEntryPresenter();
        //rootView = null;
    }
    public void onCreateView() {

    }
    public void onStop() {
        super.onStop();
    }

    @Override
    public void notifyDataReady(User user, Config config) {
        browseEntryPresenter.setUser(user);
    }

    @Override
    public void notifyConfigChanged() {

    }

    public void jumpToDate(Date date){
        browseEntryPresenter.selectEntry(date);
    }

    public List<Item> getSelectedEventItems(){
        return browseEntryPresenter.getSelectedEventItems();
    }

    public List<Item> getSelectedCheckBoxItems(){
        return browseEntryPresenter.getSelectedCheckBoxItems();
    }

    public List<Item> getSelectedNoteItems(){
        return browseEntryPresenter.getSelectedNoteItems();
    }
}
