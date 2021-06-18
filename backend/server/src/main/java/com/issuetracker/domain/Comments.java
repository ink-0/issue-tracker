package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Comments {
    private final List<Comment> comments = new ArrayList<>();

    public void add(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> toList() {
        return comments;
    }
}
