package com.issuetracker.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.List;

public class Issue {

    @Id
    private final Long issueId;

    private final MilestoneInfo milestoneInfo;

    private final String title;

    private final String content;

    private final IssueStatus status;

    private final IssueWriter writer;

    private final LocalDateTime createdDateTime;

    //TODO. 추후 일급컬렉션으로 변경
    private final List<Assignee> assignees;

    private final Labels labels;

    public Issue(Long issueId, MilestoneInfo milestoneInfo, String title, String content, IssueStatus status, IssueWriter writer, LocalDateTime createdDateTime, List<Assignee> assignees, Labels labels) {
        this.issueId = issueId;
        this.milestoneInfo = milestoneInfo;
        this.title = title;
        this.content = content;
        this.status = status;
        this.writer = writer;
        this.createdDateTime = createdDateTime;
        this.assignees = assignees;
        this.labels = labels;
    }

    public Long getIssueId() {
        return issueId;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public IssueStatus getStatus() {
        return status;
    }

    public IssueWriter getWriter() {
        return writer;
    }

    public List<Assignee> getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }
}
