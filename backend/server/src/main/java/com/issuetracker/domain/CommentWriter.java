package com.issuetracker.domain;

import java.util.List;

public class CommentWriter extends Writer {
    public CommentWriter(String name, String profileImageUrl, List<String> emails) {
        super(name, profileImageUrl, emails);
    }
}
