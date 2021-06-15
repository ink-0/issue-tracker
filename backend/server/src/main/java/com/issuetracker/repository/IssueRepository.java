package com.issuetracker.repository;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.Issues;
import com.issuetracker.domain.auth.User;
import org.springframework.stereotype.Repository;

@Repository
public class IssueRepository {
    public Issues getIssues(User user) {
        Issues issues = new Issues();
        issues.add(new Issue("임시 타이틀"));
        return issues;
    }
}
