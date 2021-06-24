package com.issuetracker.dto.ios;

import com.issuetracker.domain.Assignee;
import com.issuetracker.domain.auth.Users;
import com.issuetracker.dto.auth.UserDto;

import java.util.List;
import java.util.stream.Collectors;

public class IosAssigneesDto {

    private final List<UserDto> users;

    public IosAssigneesDto(List<UserDto> users) {
        this.users = users;
    }

    public static IosAssigneeDto from(Assignee assignee) {
        return new IosAssigneeDto(assignee.getId(), assignee.getName(), assignee.getProfileImageUrl());
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
