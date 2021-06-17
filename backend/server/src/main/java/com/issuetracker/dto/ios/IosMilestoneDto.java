package com.issuetracker.dto.ios;

import com.issuetracker.domain.Issues;
import com.issuetracker.domain.Milestone;
import com.issuetracker.domain.MilestoneInfo;

public class IosMilestoneDto {

    private Long id;

    private Issues issues;

    private MilestoneInfo milestoneInfo;

    public IosMilestoneDto(Long id, Issues issues, MilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public static IosMilestoneDto from(Milestone milestone) {
        return new IosMilestoneDto(milestone.getId(), milestone.getIssues(), milestone.getMilestoneInfo());
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
