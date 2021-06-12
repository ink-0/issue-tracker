package com.issuetracker.dto.auth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class UserInfoDto {

    private String name;

    private String avatarUrl;

    public UserInfoDto() {}

    public UserInfoDto(String name, String avatarUrl) {
        this.name = name;
        this.avatarUrl = avatarUrl;
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

    /*
    public User toUser() {
        return new User(name, avatarUrl);
    }

    public static UserDto from(User user) {
        return new UserDto(user.getName(), user.getAvatarUrl());
    }
    */
}
