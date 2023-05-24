package com.application.youtubeplaylist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.application.youtubeplaylist.entity.PlayList;

public class PlayListAdapter extends RecyclerView.Adapter<PlayListAdapter.PlayListViewHolder> {

    static Context context;
    static PlayList playList;


    public PlayListAdapter(Context _context, PlayList _playList) {
        context = _context;
        playList = _playList;
    }

    @NonNull
    @Override
    public PlayListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the layout
        View view = LayoutInflater.from(context).inflate(R.layout.item_recyclerview_layout, parent, false);
        return new PlayListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayListViewHolder holder, int position) {
        // Set the data
        holder.itemLinkTV.setText(playList.getLinks().get(position));
    }

    @Override
    public int getItemCount() {
        // Return the size of the list
        return playList.getLinks().size();
    }

    public static class PlayListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView itemLinkTV;

        public PlayListViewHolder(@NonNull View itemView) {
            // Initialize the views
            super(itemView);

            itemLinkTV = itemView.findViewById(R.id.itemLinkTV);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            // Get the position of the item that was clicked
            int position = getAdapterPosition();

            // Get the link at the position
            String link = playList.getLinks().get(position);

            // Open the YouTubeActivity
            openYouTubeActivity(link);
        }
    }

    public static void openYouTubeActivity(String link) {
        Intent intent = new Intent(context, YouTubeActivity.class);
        intent.putExtra("link", link);
        context.startActivity(intent);
    }

}
