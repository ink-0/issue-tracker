package com.issuetracker.dto.auth;

import com.issuetracker.domain.auth.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private String id;

    private String name;

    private String profileImageUrl;

    private List<String> emails;

    protected UserDto() {}

    public UserDto(String id, String name, String profileImageUrl, List<String> emails) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
        this.emails = emails;
    }

    public User toUser() {
        return new User(id, name, profileImageUrl, emails);
    }

    public static UserDto from(UserInfoDto userInfoDto, UserEmailDto[] emails) {
        return new UserDto(userInfoDto.getLogin(),
                userInfoDto.getName(),
                userInfoDto.getAvatarUrl(),
                Arrays.stream(emails).map(dto -> dto.getEmail()).collect(Collectors.toList()));
    }

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName(), user.getProfileImageUrl(), user.getEmails());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public List<String> getEmails() {
        return emails;
    }
}
