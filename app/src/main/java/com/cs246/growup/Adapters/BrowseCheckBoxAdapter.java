package com.cs246.growup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cs246.growup.Models.CheckBoxItem;
import com.cs246.growup.Models.Item;
import com.cs246.growup.R;
import java.util.List;

/**
 * Adapter for browsing a check box item.
 */
public class BrowseCheckBoxAdapter extends RecyclerView.Adapter<BrowseCheckBoxAdapter.CheckBoxViewHolder> {

    private List<Item> items;

    /**
     * Constructor
     * @param items Items to adapt.
     */
    public BrowseCheckBoxAdapter(List<Item> items) {
        this.items = items;
    }

    /**
     * Internal class. Provide a reference to the views for each data item.
     */
    public static class CheckBoxViewHolder extends RecyclerView.ViewHolder {

        public CheckedTextView checkBoxView;

        public CheckBoxViewHolder(View checkBoxItemView) {
            super(checkBoxItemView);

            checkBoxView = checkBoxItemView.findViewById(R.id.checkedTextView);
        }
    }

    /**
     * Create new views (invoked by the layout manager)
     * @param parent Context parent.
     * @param viewType
     * @return Returns a CheckBoxViewHolder object.
     */
    @Override
    public BrowseCheckBoxAdapter.CheckBoxViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View checkBoxItemView = inflater.inflate(R.layout.checkbox_item, parent, false);

        // Return a new holder instance
        BrowseCheckBoxAdapter.CheckBoxViewHolder viewHolder = new BrowseCheckBoxAdapter.CheckBoxViewHolder(checkBoxItemView);
        return viewHolder;
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     * @param holder Contains the views to replace data in.
     * @param position Position of the item in the list; used to get the information to load.
     */
    @Override
    public void onBindViewHolder(BrowseCheckBoxAdapter.CheckBoxViewHolder holder, int position) {
        // - get element from your dataset at this position
        CheckBoxItem item = (CheckBoxItem)items.get(position);

        // - replace the contents of the view with that element
        CheckedTextView checkBoxView = holder.checkBoxView;
        checkBoxView.setChecked(item.isComplete());
        checkBoxView.setText(item.getTitle());
    }

    /**
     * Gets the item count.
     * @return Returns the number of items as an int.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
}