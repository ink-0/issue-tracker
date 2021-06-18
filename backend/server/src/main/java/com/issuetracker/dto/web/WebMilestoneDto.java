package com.issuetracker.dto.web;

import com.issuetracker.domain.Milestone;

public class WebMilestoneDto {

    private Long id;

    private WebIssuesDto issues;

    private WebMilestoneInfo milestoneInfo;

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

    public void setId(Long id) {
        this.id = id;
    }

    public WebIssuesDto getIssues() {
        return issues;
    }

    public void setIssues(WebIssuesDto issues) {
        this.issues = issues;
    }

    public WebMilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(WebMilestoneInfo milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }
}
