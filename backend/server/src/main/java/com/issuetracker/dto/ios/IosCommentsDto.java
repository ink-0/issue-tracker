package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comments;

import java.util.List;
import java.util.stream.Collectors;

public class IosCommentsDto {

    private final List<IosCommentDto> comments;

    public IosCommentsDto(List<IosCommentDto> comments) {
        this.comments = comments;
    }

    public static IosCommentsDto from(Comments comments) {
        return new IosCommentsDto(comments.toList().stream()
                .map(IosCommentDto::from)
                .collect(Collectors.toList()));
    }

    public List<IosCommentDto> getComments() {
        return comments;
    }
}
