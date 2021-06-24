package com.issuetracker.domain;

public class Assignee {
    private final String id;
    private String name;
    private String profileImageUrl;

    public Assignee(String id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
