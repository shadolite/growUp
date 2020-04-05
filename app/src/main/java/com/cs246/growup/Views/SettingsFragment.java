package com.cs246.growup.Views;

import android.view.View;

import androidx.fragment.app.Fragment;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.Listener;

public class SettingsFragment extends Fragment implements Listener {
    public void onCreate() {}
    public View onCreateView() {return null;}

    //only needed if we need to override the onStop() method included with AppCompatActivity
    public void onStop() {
        super.onStop();
    }
    public void notifyDataReady() {}

    @Override
    public void notifyDataReady(User user, Config config) {

    }

    public void notifyConfigChanged() {}
}
