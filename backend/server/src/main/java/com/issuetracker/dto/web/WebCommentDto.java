package com.issuetracker.dto.web;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.auth.User;

import java.time.LocalDateTime;

public class WebCommentDto {

    private Long id;

    private User write;

    private String content;

    private LocalDateTime dateTime;

    public WebCommentDto(Long id, User write, String content, LocalDateTime dateTime) {
        this.id = id;
        this.write = write;
        this.content = content;
        this.dateTime = dateTime;
    }

    public static WebCommentDto from(Comment comment) {
        return new WebCommentDto(comment.getId(), comment.getWrite(), comment.getContent(), comment.getDateTime());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getWrite() {
        return write;
    }

    public void setWrite(User write) {
        this.write = write;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
