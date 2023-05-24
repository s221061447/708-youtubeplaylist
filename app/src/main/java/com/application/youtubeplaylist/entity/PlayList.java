package com.application.youtubeplaylist.entity;

import java.util.List;

public class PlayList {

    private String userId;
    private List<String> links;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

}