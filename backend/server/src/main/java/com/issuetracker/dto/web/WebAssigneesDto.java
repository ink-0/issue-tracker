package com.issuetracker.dto.web;

import com.issuetracker.domain.auth.Users;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class WebAssigneesDto {

    private final List<UserDto> users;

    public WebAssigneesDto(List<UserDto> users) {
        this.users = users;
    }

    public static WebAssigneesDto from(Users users) {
        return new WebAssigneesDto(users.toList().stream()
                .map(UserDto::from)
                .collect(Collectors.toList()));
    }

    public List<UserDto> toList() {
        return users;
    }

    public Users toUsers() {
        return new Users(users.stream()
                .map(UserDto::toUser)
                .collect(Collectors.toList()));
    }

    public List<UserDto> getUsers() {
        return users;
    }
}
