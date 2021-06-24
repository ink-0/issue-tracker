package com.issuetracker.dto.web;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Writer;

import java.time.LocalDateTime;

public class WebCommentDto {

    private Long id;

    private Writer writer;

    private String content;

    private LocalDateTime dateTime;

    public WebCommentDto(Long id, Writer writer, String content, LocalDateTime dateTime) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.dateTime = dateTime;
    }

    public static WebCommentDto from(Comment comment) {
        return new WebCommentDto(comment.getId(), comment.getWriter(), comment.getContent(), comment.getDateTime());
    }

    public Long getId() {
        return id;
    }

    public Writer getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
