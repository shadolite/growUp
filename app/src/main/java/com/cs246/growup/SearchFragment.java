package com.cs246.growup;

import android.view.View;
import androidx.fragment.app.Fragment;

import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;

import java.util.List;

public class SearchFragment extends Fragment implements Listener {
    public void onCreate() {}
    public View onCreateView() {return null;}
    public void notifyDataReady() {}
    private void updateSearchResults() {}

    @Override
    public void notifyDataReady(Config config, List<Goal> goals, Entry entry) {

    }

    @Override
    public void NotifyConfigChanged() {

    }
}
