package com.cs246.growup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cs246.growup.Models.Goal;
import com.cs246.growup.R;
import java.util.List;

/**
 * Adapter for browsing goal objects.
 */
public class BrowseGoalAdapter extends RecyclerView.Adapter<BrowseGoalAdapter.GoalViewHolder> {

    private List<Goal> goals;

    /**
     * Constructor
     * @param goals Items to adapt.
     */
    public BrowseGoalAdapter(List<Goal> goals) {
        this.goals = goals;
    }

    /**
     * Internal class. Provide a reference to the views for each data item.
     */
    public static class GoalViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView descriptionTextView;
        public TextView dueDateTextView;

        public GoalViewHolder(View goalView) {
            super(goalView);

            titleTextView = goalView.findViewById(R.id.goalTitleTextView);
            descriptionTextView = goalView.findViewById(R.id.goalDescriptionTextView);
            dueDateTextView = goalView.findViewById(R.id.goalDueDateTextView);
        }
    }

    /**
     * Create new views (invoked by the layout manager)
     * @param parent Context parent.
     * @param viewType
     * @return Returns a NoteViewHolder object.
     */
    @Override
    public BrowseGoalAdapter.GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View goalView = inflater.inflate(R.layout.goal, parent, false);

        // Return a new holder instance
        BrowseGoalAdapter.GoalViewHolder viewHolder = new BrowseGoalAdapter.GoalViewHolder(goalView);
        return viewHolder;
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     * @param holder Contains the views to replace data in.
     * @param position Position of the item in the list; used to get the information to load.
     */
    @Override
    public void onBindViewHolder(GoalViewHolder holder, int position) {
        // - get element from your dataset at this position
        Goal goal = (Goal)goals.get(position);

        // - replace the contents of the view with that element
        TextView titleView = holder.titleTextView;
        titleView.setText(goal.getTitle());

        TextView descriptionView = holder.descriptionTextView;
        descriptionView.setText(goal.getDescription());

        TextView dueDateView = holder.dueDateTextView;
        dueDateView.setText(String.format(
                "Due On: %1$s",
                goal.GetStringDueDate()
        ));
    }

    /**
     * Gets the item count.
     * @return Returns the number of items as an int.
     */
    @Override
    public int getItemCount() {
        return goals.size();
    }
}