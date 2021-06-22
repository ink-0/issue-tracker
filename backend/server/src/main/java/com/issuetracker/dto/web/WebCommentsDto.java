package com.issuetracker.dto.web;

import com.issuetracker.domain.DetailedComment;

import java.util.List;
import java.util.stream.Collectors;

public class WebCommentsDto {

    private final List<WebCommentDto> comments;

    public WebCommentsDto(List<WebCommentDto> comments) {
        this.comments = comments;
    }

    public static WebCommentsDto from(List<DetailedComment> comments) {
        return new WebCommentsDto(comments.stream()
                .map(WebCommentDto::from)
                .collect(Collectors.toList()));
    }

    public List<WebCommentDto> getComments() {
        return comments;
    }
}
