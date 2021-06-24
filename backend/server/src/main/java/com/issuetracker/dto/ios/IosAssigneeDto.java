package com.issuetracker.dto.ios;

import com.issuetracker.domain.Assignee;

public class IosAssigneeDto {
    private final String id;

    private String name;

    private String profileImageUrl;

    public IosAssigneeDto(String id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public static IosAssigneeDto from(Assignee assignee){
        return new IosAssigneeDto(assignee.getId(),assignee.getName(),assignee.getProfileImageUrl());
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
}
