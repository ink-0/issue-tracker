package com.issuetracker.dto.ios;

import com.issuetracker.domain.Assignee;

public class IosAssigneeDto {
    private final String id;
    private final String name;
    private final String profileImageUrl;

    public IosAssigneeDto(String id, String name, String profileImageUrl) {
        this.id = id;
        this.name = name;
        this.profileImageUrl = profileImageUrl;
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

    public static IosAssigneeDto from(Assignee assignee) {
        return new IosAssigneeDto(assignee.getId(), assignee.getName(), assignee.getProfileImageUrl());
    }

    public Assignee toAssignee() {
        return new Assignee(id, name, profileImageUrl);
    }
}
