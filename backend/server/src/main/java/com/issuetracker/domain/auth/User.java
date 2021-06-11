package com.issuetracker.domain.auth;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private final String login;

    private String name; //INFO. NULL값 허용

    private String avatarUrl; //INFO. NULL값 허용

    public User(String login, String name, String avatarUrl) {
        this.login = login;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }


}
