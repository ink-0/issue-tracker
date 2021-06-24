package com.issuetracker.dto.web;

import com.issuetracker.domain.IssueWriter;

public class WebIssueWriterDto {

    private final String name;

    private final String profileImageUrl;

    public WebIssueWriterDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public static WebIssueWriterDto from(IssueWriter issueWriter) {
        return new WebIssueWriterDto(issueWriter.getName(), issueWriter.getProfileImageUrl());
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
