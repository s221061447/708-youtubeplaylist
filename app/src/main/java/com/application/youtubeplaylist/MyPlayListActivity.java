package com.application.youtubeplaylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.application.youtubeplaylist.entity.PlayList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyPlayListActivity extends AppCompatActivity {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    RecyclerView playlistRV;
    PlayListAdapter playListAdapter;
    RecyclerView.LayoutManager playListLayoutManager;

    private PlayList playList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_play_list);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                playList = objectMapper.readValue(extras.getString("playList"), PlayList.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        // Set recycler views
        playlistRV = findViewById(R.id.playlistRV);
        playListLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        playListAdapter = new PlayListAdapter(this, playList);
        playlistRV.setLayoutManager(playListLayoutManager);
        playlistRV.setAdapter(playListAdapter);
    }
}