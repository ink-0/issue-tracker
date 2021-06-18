package com.issuetracker.dto.auth;

import com.issuetracker.domain.auth.Users;

import java.util.List;
import java.util.stream.Collectors;

public class UsersDto {
    private final List<UserDto> users;

    public UsersDto(List<UserDto> users) {
        this.users = users;
    }

    public static UsersDto from(Users users) {
        return new UsersDto(users.toList().stream()
                .map(UserDto::from)
                .collect(Collectors.toList()));
    }

    public List<UserDto> getUsers() {
        return users;
    }
}
