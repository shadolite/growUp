package com.cs246.growup.Views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.cs246.growup.Presenters.Listener;
import com.cs246.growup.Presenters.MainPresenter;
import com.cs246.growup.R;

public class MainActivity extends AppCompatActivity {

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void registerFragment(Listener fragment){
        presenter.registerListeners(fragment);
    }

    public void loadFragment(int tabID){

    }

}
