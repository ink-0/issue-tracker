package com.issuetracker.domain;

import com.issuetracker.domain.auth.User;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Issue {

    @Id
    private final Long issueId;

    private final MilestoneInfo milestoneInfo;

    private final String title;

    private final String content;

    private final IssueStatus status;

    private final User writer;

    private final LocalDateTime createdDateTime;

    private final Assignees assignees;

    private final Labels labels;

    public Issue(Long issueId, MilestoneInfo milestoneInfo, String title, String content, IssueStatus status, User writer, LocalDateTime createdDateTime, Assignees assignees, Labels labels) {
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

    public User getWriter() {
        return writer;
    }

    public Assignees getAssignees() {
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