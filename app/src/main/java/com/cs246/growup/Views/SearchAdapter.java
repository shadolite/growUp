package com.cs246.growup.Views;

import android.os.AsyncTask;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import com.cs246.growup.R;
import com.cs246.growup.Models.Config;
import com.cs246.growup.Models.SearchResult;


public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    private SearchResult results;
    private Config config;

    public SearchAdapter(SearchResult results, Config config) {
        this.results = results;
        this.config = config;
    }

    @NonNull
    @Override
    public SearchAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(
                R.layout.dp_goal, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchAdapter.ViewHolder viewHolder, int i) {
        new VerseMarker(viewHolder).execute(results.getData().get(i).getGoal().getTitle(), results.getSearchTerm(),
                results.getData().get(i).getGoal().getTitle());
    }

    @Override
    public int getItemCount() {
        return results.getData().size();
    }

    private class VerseMarker extends AsyncTask<String,Void,String> {

        private ViewHolder viewHolder;

        public VerseMarker(ViewHolder viewHolder) {
            this.viewHolder = viewHolder;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

        }

        @Override
        protected String doInBackground(String... strings) {
            String verseText = strings[0];
            String searchTerm = strings[1];
            String verseRef = strings[2];
            if (searchTerm.equals("") == false) {
                int pos = 0;
                do {
                    pos = verseText.toUpperCase().indexOf(searchTerm.toUpperCase(), pos);
                    if (pos != -1) {
                        String before = "";
                        String middle = "";
                        String after = "";
                        int prevLength = verseText.length();
                        if (pos > 0) {
                            before = verseText.substring(0, pos);
                        }
                        middle = verseText.substring(pos, pos + searchTerm.length());
                        if (pos + searchTerm.length() < verseText.length()) {
                            after = verseText.substring(pos + searchTerm.length(), verseText.length());
                        }
                        verseText = before + "<font color=\"red\">" + middle + "</font>" + after;
                        pos += (verseText.length() - prevLength);
                    }
                }
                while (pos != -1);
            }
            String text = "<b>"+ verseRef+"</b>: "+verseText;

            return text;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvText;

        public ViewHolder(View itemView) {
            super(itemView);
          //  tvText = itemView.findViewById(R.id.tv_verse);
        }

        public TextView getTvText() {
            return tvText;
        }

    }
}