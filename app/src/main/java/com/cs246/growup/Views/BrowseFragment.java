package com.cs246.growup.Views;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.Entry;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.User;
import com.cs246.growup.Presenters.Listener;

import java.util.List;


public class BrowseFragment extends AppCompatActivity implements Listener {

    public BrowseFragment() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    public void onCreateView() {

    }
    public void onStop() {
        super.onStop();
    }

    @Override
    public void notifyDataReady(User user, Config config) {

    }

    @Override
    public void notifyConfigChanged() {

    }
}
