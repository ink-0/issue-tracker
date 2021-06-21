package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;

import java.util.List;

public class User {

    @Id
    private final String id;

    private String name;

    private String profileImageUrl;

    private List<String> emails;

    public User(String id, String name, String profileImageUrl, List<String> emails) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.emails = emails;
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

    public List<String> getEmails() {
        return emails;
    }
}
