package com.issuetracker.domain;

import java.util.List;

abstract class Writer {

    private final String name;

    private final String profileImageUrl;

    private List<String> emails;

    public Writer(String name, String profileImageUrl, List<String> emails) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public List<String> getEmails() {
        return emails;
    }
}
