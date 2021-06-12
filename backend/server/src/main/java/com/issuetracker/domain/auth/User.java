package com.issuetracker.domain.auth;

import com.issuetracker.dto.auth.UserDto;
import org.springframework.data.annotation.Id;

public class User {

    @Id
    private final String email;

    private String name; //INFO. NULL값 허용

    private String avatarUrl; //INFO. NULL값 허용

    public User(UserDto userDto) {
        this.email = userDto.getEmail();
        this.name = userDto.getName();
        this.avatarUrl = userDto.getAvatarUrl();
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
