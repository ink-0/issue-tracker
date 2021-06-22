package com.issuetracker.dto.web;

import com.issuetracker.domain.Milestone;

import java.util.List;

public class WebMilestoneDto {

    private final Long id;

    private final WebIssuesDto issues;

    private final WebMilestoneInfo milestoneInfo;

    public WebMilestoneDto(Long id, WebIssuesDto issues, WebMilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public static WebMilestoneDto from(Milestone milestone) {
        return new WebMilestoneDto(milestone.getId(), WebIssuesDto.from(milestone.getIssues()), WebMilestoneInfo.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public List<WebIssueSummaryDto> getIssues() {
        return issues.getIssues();
    }

    public WebMilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }
}
