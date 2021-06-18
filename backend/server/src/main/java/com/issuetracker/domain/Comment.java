package com.issuetracker.domain;

import com.issuetracker.domain.auth.User;

import java.time.LocalDateTime;

public class Comment {

    private final Long id;

    private final Long issueId;

    private final User write;

    private final String content;

    private final LocalDateTime dateTime;

    public Comment(Long id, Long issueId, User write, String content, LocalDateTime dateTime) {
        this.id = id;
        this.issueId = issueId;
        this.write = write;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public User getWrite() {
        return write;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public Long getIssueId() {
        return issueId;
    }
}
