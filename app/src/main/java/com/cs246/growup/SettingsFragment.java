package com.cs246.growup;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;

import java.util.List;

public class SettingsFragment extends Fragment implements Listener {
    public void onCreate() {}
    public View onCreateView() {return null;}

    //only needed if we need to override the onStop() method included with AppCompatActivity
    public void onStop() {
        super.onStop();
    }
    public void notifyDataReady() {}
    public void notifyConfigChanged() {}

    @Override
    public void notifyDataReady(Config config, List<Goal> goals, Entry entry) {

    }

    @Override
    public void NotifyConfigChanged() {

    }
}
