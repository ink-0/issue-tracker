package com.issuetracker.domain;

public class Writer {
    private final String name;
    private final String profileImageUrl;

    public Writer(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
