package com.cs246.growup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cs246.growup.Models.Item;
import com.cs246.growup.Models.NoteItem;
import com.cs246.growup.R;
import java.util.List;

public class BrowseNoteAdapter extends RecyclerView.Adapter<BrowseNoteAdapter.NoteViewHolder> {

    private List<Item> items;

    // Provide a suitable constructor (depends on the kind of items)
    public BrowseNoteAdapter(List<Item> items) {
        this.items = items;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView bodyTextView;

        public NoteViewHolder(View noteItemView) {
            super(noteItemView);

            titleTextView = noteItemView.findViewById(R.id.noteTitleTextView);
            bodyTextView = noteItemView.findViewById(R.id.bodyTextView);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BrowseNoteAdapter.NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View noteItemView = inflater.inflate(R.layout.note_item, parent, false);

        // Return a new holder instance
        BrowseNoteAdapter.NoteViewHolder viewHolder = new BrowseNoteAdapter.NoteViewHolder(noteItemView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        // - get element from your dataset at this position
        NoteItem item = (NoteItem)items.get(position);

        // - replace the contents of the view with that element
        TextView titleView = holder.titleTextView;
        titleView.setText(item.getTitle());

        TextView bodyView = holder.bodyTextView;
        bodyView.setText(item.body);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}