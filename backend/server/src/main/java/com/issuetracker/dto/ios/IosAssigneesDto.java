package com.issuetracker.dto.ios;

import com.issuetracker.domain.auth.Users;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class IosAssigneesDto {

    private final List<UserDto> users;

    public IosAssigneesDto(List<UserDto> users) {
        this.users = users;
    }

    public static IosAssigneesDto from(Users users) {
        return new IosAssigneesDto(users.toList().stream()
                .map(UserDto::from)
                .collect(Collectors.toList()));
    }

    public List<UserDto> getUsers() {
        return users;
    }
}
