package com.issuetracker.dto.web;

import com.issuetracker.domain.DetailedComment;

import java.time.LocalDateTime;

public class WebCommentDto {

    private final String writerId;

    private final String content;

    private final LocalDateTime dateTime;

    private final String profileImageUrl;

    public WebCommentDto(String writerId, String content, LocalDateTime dateTime, String profileImageUrl) {
        this.writerId = writerId;
        this.content = content;
        this.dateTime = dateTime;
        this.profileImageUrl = profileImageUrl;
    }

    public static WebCommentDto from(DetailedComment comment) {
        return new WebCommentDto(comment.getWriterId(), comment.getContent(), comment.getDateTime(), comment.getProfileImageUrl());
    }

    public String getWriterId() {
        return writerId;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }
}
