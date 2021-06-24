package com.issuetracker.dto.ios;

import com.issuetracker.domain.IssueWriter;

public class IosIssueWriterDto {

    private final String name;

    private final String profileImageUrl;

    public IosIssueWriterDto(String name, String profileImageUrl) {
        this.name = name;
        this.profileImageUrl = profileImageUrl;
    }

    public static IosIssueWriterDto from(IssueWriter issueWriter){
        return new IosIssueWriterDto(issueWriter.getName(),issueWriter.getProfileImageUrl());
    }

    public String getName() {
        return name;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
