package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private final String email;

    private String name; //INFO. NULL값 허용

    private String avatarUrl; //INFO. NULL값 허용

    public User(String email, String name, String avatarUrl) {
        this.email = email;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

}
