package com.cs246.growup.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.cs246.growup.Models.EventItem;
import com.cs246.growup.Models.Item;
import com.cs246.growup.R;
import java.util.List;

public class BrowseEventAdapter extends RecyclerView.Adapter<BrowseEventAdapter.EventViewHolder> {

    private List<Item> items;

    // Provide a suitable constructor (depends on the kind of items)
    public BrowseEventAdapter(List<Item> items) {
        this.items = items;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class EventViewHolder extends RecyclerView.ViewHolder {

        // each data item is just a string in this case
        public TextView eventPeriodTextView;
        public TextView eventTitleTextView;

        public EventViewHolder(View eventItemView) {
            super(eventItemView);

            eventPeriodTextView = eventItemView.findViewById(R.id.eventPeriodTextView);
            eventTitleTextView = eventItemView.findViewById(R.id.eventTitleTextView);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public BrowseEventAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View noteItemView = inflater.inflate(R.layout.event_item, parent, false);

        // Return a new holder instance
        BrowseEventAdapter.EventViewHolder viewHolder = new BrowseEventAdapter.EventViewHolder(noteItemView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(BrowseEventAdapter.EventViewHolder holder, int position) {
        // - get element from your dataset at this position
        EventItem item = (EventItem)items.get(position);

        TextView startTimeView = holder.eventPeriodTextView;
        startTimeView.setText(item.getEventTimePeriod());

        // - replace the contents of the view with that element
        TextView titleView = holder.eventTitleTextView;
        titleView.setText(item.getTitle());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return items.size();
    }
}