package com.issuetracker.domain;

import java.util.List;

public class IssueWriter extends Writer {
    public IssueWriter(String name, String profileImageUrl, List<String> emails) {
        super(name, profileImageUrl, emails);
    }
}
