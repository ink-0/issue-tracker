package com.issuetracker.dto.auth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.issuetracker.domain.auth.User;

public class UserDto {

    private String login;

    private String name;

    private String avatarUrl;

    public UserDto() {}

    public UserDto(String login, String name, String avatarUrl) {
        this.login = login;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }

    @JsonGetter("login")
    public String getLogin() {
        return login;
    }

    @JsonSetter("login")
    public void setLogin(String login) {
        this.login = login;
    }

    @JsonGetter("name")
    public String getName() {
        return name;
    }

    @JsonSetter("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonGetter("avatar_url")
    public String getAvatarUrl() {
        return avatarUrl;
    }

    @JsonSetter("avatar_url")
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public User toUser() {
        return new User(login, name, avatarUrl);
    }

    public static UserDto from(User user) {
        return new UserDto(user.getLogin(), user.getName(), user.getAvatarUrl());
    }
}
