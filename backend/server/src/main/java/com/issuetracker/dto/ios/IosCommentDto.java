package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Writer;

import java.time.LocalDateTime;

public class IosCommentDto {

    private Long id;

    private Writer writer;

    private String content;

    private LocalDateTime dateTime;

    public IosCommentDto(Long id, Writer writer, String content, LocalDateTime dateTime) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.dateTime = dateTime;
    }

    public static IosCommentDto from(Comment comment) {
        return new IosCommentDto(comment.getId(), comment.getWriter(), comment.getContent(), comment.getDateTime());
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

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
