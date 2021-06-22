package com.issuetracker.dto.ios;

import com.issuetracker.domain.Milestone;

import java.util.List;

public class IosMilestoneDto {

    private Long id;

    private IosIssuesDto issues;

    private IosMilestoneInfo milestoneInfo;

    public IosMilestoneDto(Long id, IosIssuesDto issues, IosMilestoneInfo milestoneInfo) {
        this.id = id;
        this.issues = issues;
        this.milestoneInfo = milestoneInfo;
    }

    public static IosMilestoneDto from(Milestone milestone) {
        return new IosMilestoneDto(milestone.getId(), IosIssuesDto.from(milestone.getIssues()), IosMilestoneInfo.from(milestone.getMilestoneInfo()));
    }

    public Long getId() {
        return id;
    }

    public List<IosIssueSummaryDto> getIssues() {
        return issues.getIssues();
    }

    public IosMilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }
}
