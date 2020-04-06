package com.cs246.growup.Presenters;

import com.cs246.growup.Models.Goal;
import com.cs246.growup.Models.User;
import com.cs246.growup.Views.BrowseGoalsView;

import java.util.ArrayList;
import java.util.List;

/**
 * Presenter for the browse goal activity.
 */
public class BrowseGoalPresenter {

    private List<Goal> currentGoals;
    private List<Goal> completedGoals;
    private boolean userReady;
    BrowseGoalsView browseGoalsActivity;

    /**
     * Constructor
     * @param browseGoalsView Activity the presenter belongs to.
     */
    public BrowseGoalPresenter(BrowseGoalsView browseGoalsView) {

        currentGoals = new ArrayList<>();
        completedGoals = new ArrayList<>();
        browseGoalsActivity = browseGoalsView;
    }

    /**
     * Initializes the presenter based on user data.
     * @param user
     */
    public void initialize(User user){

        loadCurrentGoals(user);
        loadCompletedGoals(user);

        browseGoalsActivity.notifyDataReady();
    }

    /**
     * Loads completed goals from the user.
     * @param user User to search for completed goals.
     */
    private void loadCompletedGoals(User user) {
        completedGoals.clear();

        for (Goal goal :
                user.getGoals()) {
            if (goal.isComplete()){
                completedGoals.add(goal);
            }
        }
    }

    /**
     * Loads current goals from the user.
     * @param user User to search for current goals.
     */
    private void loadCurrentGoals(User user) {
        currentGoals.clear();

        for (Goal goal :
                user.getGoals()) {
            if (!goal.isComplete()){
                currentGoals.add(goal);
            }
        }
    }

    /**
     * Gets current goals from the presenter.
     * @return Returns a list of Goal objects.
     */
    public List<Goal> getCurrentGoals() {
        return currentGoals;
    }

    /**
     * Gets completed goals from the presenter.
     * @return Returns a list of Goal objects.
     */
    public List<Goal> getCompletedGoals() {
        return completedGoals;
    }
}