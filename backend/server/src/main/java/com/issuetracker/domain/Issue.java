package com.issuetracker.domain;

import com.issuetracker.domain.auth.User;
import com.issuetracker.domain.auth.Users;

import java.time.LocalDateTime;

public class Issue {

    private final Long issueId;

    private final String title;

    private final String content;

    private final boolean status;

    private final User writer;

    private final LocalDateTime createdDateTime;

    private final Users assignees;

    private final Labels labels;

    public Issue(Long issueId, String title, String content, boolean status, User writer, LocalDateTime createdDateTime, Users assignees, Labels labels) {
        this.issueId = issueId;
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

    public boolean isStatus() {
        return status;
    }

    public User getWriter() {
        return writer;
    }

    public Users getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }
}
