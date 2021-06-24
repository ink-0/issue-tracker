package com.issuetracker.dto.web;

import com.issuetracker.domain.Assignee;

public class WebAssigneeDto {
    private final String id;
    private final String name;
    private final String profileImageUrl;

    public WebAssigneeDto(String id, String name, String profileImageUrl) {
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

    public static WebAssigneeDto from(Assignee assignee) {
        return new WebAssigneeDto(assignee.getId(), assignee.getName(), assignee.getProfileImageUrl());
    }

    public Assignee toAssignee() {
        return new Assignee(id, name, profileImageUrl);
    }
}
