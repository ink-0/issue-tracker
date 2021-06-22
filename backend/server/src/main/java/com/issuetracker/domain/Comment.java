package com.issuetracker.domain;

import java.time.LocalDateTime;

public class Comment {

    private final Long id;

    private final Long issueId;

    private CommentWriter writer;

    private final String content;

    private final LocalDateTime dateTime;

    public Comment(Long id, Long issueId, CommentWriter writer, String content, LocalDateTime dateTime) {
        this.id = id;
        this.issueId = issueId;
        this.writer = writer;
        this.content = content;
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }

    public CommentWriter getWriter() {
        return writer;
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
