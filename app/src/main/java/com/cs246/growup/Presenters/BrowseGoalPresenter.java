package com.cs246.growup.Presenters;

import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.User;
import com.cs246.growup.Views.BrowseGoalsView;

import java.util.ArrayList;
import java.util.List;

public class BrowseGoalPresenter {
    private List<Goal> currentGoals;
    private List<Goal> completedGoals;
    private boolean userReady;
    BrowseGoalsView browseGoalsActivity;

    public BrowseGoalPresenter(BrowseGoalsView browseGoalsView) {
        currentGoals = new ArrayList<>();
        completedGoals = new ArrayList<>();
        browseGoalsActivity = browseGoalsView;
    }

    public void initialize(User user){

        loadCurrentGoals(user);
        loadCompletedGoals(user);

        browseGoalsActivity.notifyDataReady();
    }

    private void loadCompletedGoals(User user) {
        completedGoals.clear();

        for (Goal goal :
                user.getGoals()) {
            if (goal.isComplete()){
                completedGoals.add(goal);
            }
        }
    }

    private void loadCurrentGoals(User user) {
        currentGoals.clear();

        for (Goal goal :
                user.getGoals()) {
            if (!goal.isComplete()){
                currentGoals.add(goal);
            }
        }
    }

    public List<Goal> getCurrentGoals() {
        return currentGoals;
    }

    public List<Goal> getCompletedGoals() {
        return completedGoals;
    }
}
