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

/**
 * Adapter for browsing a note item.
 */
public class BrowseNoteAdapter extends RecyclerView.Adapter<BrowseNoteAdapter.NoteViewHolder> {

    private List<Item> items;

    /**
     * Constructor
     * @param items Items to adapt.
     */
    public BrowseNoteAdapter(List<Item> items) {
        this.items = items;
    }

    /**
     * Internal class. Provide a reference to the views for each data item.
     */
    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        public TextView titleTextView;
        public TextView bodyTextView;

        public NoteViewHolder(View noteItemView) {
            super(noteItemView);

            titleTextView = noteItemView.findViewById(R.id.noteTitleTextView);
            bodyTextView = noteItemView.findViewById(R.id.bodyTextView);
        }
    }

    /**
     * Create new views (invoked by the layout manager)
     * @param parent Context parent.
     * @param viewType
     * @return Returns a NoteViewHolder object.
     */
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

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     * @param holder Contains the views to replace data in.
     * @param position Position of the item in the list; used to get the information to load.
     */
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

    /**
     * Gets the item count.
     * @return Returns the number of items as an int.
     */
    @Override
    public int getItemCount() {
        return items.size();
    }
}