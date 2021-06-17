package com.issuetracker.dto.web;

import com.issuetracker.domain.Issues;
import com.issuetracker.domain.Milestone;
import com.issuetracker.domain.MilestoneInfo;

public class WebMilestoneDto {

    private Long id;

    private Issues issues;

    private MilestoneInfo milestoneInfo;

    public WebMilestoneDto(Long id, Issues issues, MilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public static WebMilestoneDto from(Milestone milestone) {
        return new WebMilestoneDto(milestone.getId(), milestone.getIssues(), milestone.getMilestoneInfo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Issues getIssues() {
        return issues;
    }

    public void setIssues(Issues issues) {
        this.issues = issues;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(MilestoneInfo milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }
}
