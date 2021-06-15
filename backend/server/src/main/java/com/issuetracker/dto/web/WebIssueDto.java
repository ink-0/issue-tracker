package com.issuetracker.dto.web;

import com.issuetracker.domain.Issue;

public class WebIssueDto {
    private final String title;

    public WebIssueDto(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static WebIssueDto from(Issue issue) {
        return new WebIssueDto(issue.getTitle());
    }
}
