package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Issues {
    private final List<Issue> issues = new ArrayList<>();

    public void add(Issue issue) {
        issues.add(issue);
    }

    public List<Issue> toList() {
        return issues;
    }

    public List<Issue> getIssues() {
        return issues;
    }
}
