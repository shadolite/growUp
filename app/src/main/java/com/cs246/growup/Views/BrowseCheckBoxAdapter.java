package com.cs246.growup.Views;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cs246.growup.Models.Item;
import com.cs246.growup.R;
import java.util.List;

public class BrowseCheckBoxAdapter extends RecyclerView.Adapter<BrowseCheckBoxAdapter.CheckBoxViewHolder> {
private List<Item> items;

// Provide a reference to the views for each data item
// Complex data items may need more than one view per item, and
// you provide access to all the views for a data item in a view holder
public static class CheckBoxViewHolder extends RecyclerView.ViewHolder {
    // each data item is just a string in this case
    public TextView textView;
    public CheckBoxViewHolder(TextView v) {
        super(v);
        textView = v;
    }
}

    // Provide a suitable constructor (depends on the kind of items)
    public BrowseCheckBoxAdapter(List<Item> items) {
        this.items = items;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CheckBoxViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_item, parent, false);
        BrowseCheckBoxAdapter.CheckBoxViewHolder vh = new BrowseCheckBoxAdapter.CheckBoxViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BrowseCheckBoxAdapter.CheckBoxViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(items.get(position).getTitle());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}