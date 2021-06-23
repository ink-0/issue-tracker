package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.CommentWriter;

import java.time.LocalDateTime;

public class IosCommentDto {

    private final String writerId;

    private final String content;

    private final LocalDateTime dateTime;

    private final String profileImageUrl;

    public IosCommentDto(String writerId, String content, LocalDateTime dateTime, String profileImageUrl) {
        this.writerId = writerId;
        this.content = content;
        this.dateTime = dateTime;
        this.profileImageUrl = profileImageUrl;
    }

    public static IosCommentDto from(Comment comment) {
        CommentWriter commentWriter = comment.getWriter();
        return new IosCommentDto(commentWriter.getName(), comment.getContent(), comment.getDateTime(), commentWriter.getProfileImageUrl());
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
