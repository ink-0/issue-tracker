package com.issuetracker.dto.ios;

import com.issuetracker.domain.Issue;

public class IosIssueDto {
    private final String title;

    public IosIssueDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static IosIssueDto from(Issue issue) {
        return new IosIssueDto(issue.getTitle());
    }
}
