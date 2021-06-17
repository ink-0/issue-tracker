package com.issuetracker.dto.web;

import com.issuetracker.domain.Issues;

import java.util.List;
import java.util.stream.Collectors;

public class WebIssuesDto {
    private final List<WebIssueSummaryDto> issues;

    public WebIssuesDto(List<WebIssueSummaryDto> issues) {
        this.issues = issues;
    }

    public static WebIssuesDto from(Issues issues) {
        return new WebIssuesDto(issues.toList().stream()
                .map(WebIssueSummaryDto::from)
                .collect(Collectors.toList()));
    }

    public List<WebIssueSummaryDto> getIssues() {
        return issues;
    }
}
