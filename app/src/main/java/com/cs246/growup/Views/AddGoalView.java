package com.cs246.growup.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;

import com.cs246.growup.Presenters.AddGoalPresenter;
import com.cs246.growup.R;
import com.cs246.growup.databinding.ActivityAddGoalViewBinding;

public class AddGoalView extends AppCompatActivity {
    ActivityAddGoalViewBinding bind;
    private AddGoalPresenter presenter;

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AddGoalPresenter();
        //setContentView(R.layout.activity_add_goal_view);
        bind = DataBindingUtil.setContentView(this, R.layout.activity_add_goal_view);
        bind.goalDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "New Goal discarded", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        bind.goalSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGoal();
            }
        });
    }

   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }


    @Override
    public void onStop() {
        super.onStop();
    }
    public void saveGoal() {
        EditText goalTitle = (EditText)bind.goalTitle;
        String title = goalTitle.getText().toString();
        presenter.goal.setTitle(title);
        System.out.println(presenter.goal.getTitle());
        Toast.makeText(getBaseContext(), presenter.goal.getTitle(), Toast.LENGTH_SHORT).show();
    }
    public void addTags(){}
    public void addTitle(){}
    public void addDescription(){}
}