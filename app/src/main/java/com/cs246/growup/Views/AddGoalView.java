package com.cs246.growup.Views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

/**
 * Activity for adding a goal.
 */
public class AddGoalView extends AppCompatActivity {

    ActivityAddGoalViewBinding bind;
    private AddGoalPresenter presenter;

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)

    /**
     * Initializes data for the activity.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new AddGoalPresenter();
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

    /**
     * Inflates the options menu.
     * @param menu Menu to inflate.
     * @return Returns true.
     */
   @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Runs necessary methods when activity is stopped.
     */
    @Override
    public void onStop() {
        super.onStop();
    }

    /**
     * Saves the user input as a goal, and calls finish() on the Activity.
     */
    public void saveGoal() {
        Intent addGoal = new Intent();
        EditText goalTitle = (EditText)bind.goalTitle;
        String title = goalTitle.getText().toString();
        EditText goalDescription = (EditText)bind.goalDescription;
        String description = goalDescription.getText().toString();
        ToggleButton spiritualTag = bind.spiritualTag;
        String spiritual = spiritualTag.getText().toString();
//        presenter.goal.addTag(spiritual);
        presenter.goal.setTitle(title);
        presenter.goal.setDescription(description);
        addGoal.putExtra("Goal", presenter.getGoal());
        setResult(RESULT_OK, addGoal);
        Toast.makeText(getBaseContext(), presenter.goal.getTitle(), Toast.LENGTH_SHORT).show();
        finish();
        /*String title = goalTitle.getText().toString();
        presenter.goal.setTitle(title);
        System.out.println(presenter.goal.getTitle());*/
    }

    public void addTags(){}
    public void addTitle(){}
    public void addDescription(){}
}