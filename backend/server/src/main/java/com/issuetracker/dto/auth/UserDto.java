package com.issuetracker.dto.auth;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.issuetracker.domain.auth.User;

public class UserDto {

    private String email;

    private String name;

    private String profileImageUrl;

    public UserDto() {}

    public UserDto(UserInfoDto userInfoDto, UserEmailDto emailDto) {
        email = emailDto.getEmail();
        name = userInfoDto.getName();
        profileImageUrl = userInfoDto.getAvatarUrl();
    }
    public UserDto(String email, String name, String profileImageUrl) {
        this.email = email;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    @JsonGetter("email")
    public String getEmail() {
        return email;
    }

    @JsonSetter("email")
    public void setEmail(String email) {
        this.email = email;
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
    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    @JsonSetter("avatar_url")
    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public User toUser(){
        return new User(email,name,profileImageUrl);
    }

    public static UserDto from(UserInfoDto userInfoDto, UserEmailDto emailDto){
        return new UserDto(userInfoDto, emailDto);
    }


}
