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

public class BrowseCheckBoxAdapter extends RecyclerView.Adapter<BrowseCheckBoxAdapter.CheckBoxViewHolder> {

    private List<Item> items;

    // Provide a suitable constructor (depends on the kind of items)
    public BrowseCheckBoxAdapter(List<Item> items) {
        this.items = items;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class CheckBoxViewHolder extends RecyclerView.ViewHolder {

        public CheckedTextView checkBoxView;

        public CheckBoxViewHolder(View checkBoxItemView) {
            super(checkBoxItemView);

            checkBoxView = checkBoxItemView.findViewById(R.id.checkedTextView);
        }
    }

    // Create new views (invoked by the layout manager)
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

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BrowseCheckBoxAdapter.CheckBoxViewHolder holder, int position) {
        // - get element from your dataset at this position
        CheckBoxItem item = (CheckBoxItem)items.get(position);

        // - replace the contents of the view with that element
        CheckedTextView checkBoxView = holder.checkBoxView;
        checkBoxView.setChecked(item.isComplete());
        checkBoxView.setText(item.getTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}