package com.issuetracker.dto.web;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class WebIssuesDto {
    private final List<WebIssueDto> issues;

    public WebIssuesDto(List<WebIssueDto> issues) {
        this.issues = issues;
    }

    public static WebIssuesDto from(Issues issues) {
        return new WebIssuesDto(issues.toList().stream()
                .map(WebIssueDto::from)
                .collect(Collectors.toList()));
    }

    public List<WebIssueDto> getIssues() {
        return issues;
    }
}
