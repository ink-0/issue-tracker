package com.issuetracker.repository;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.auth.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {
    public List<Issue> getIssues(User user) {
        List<Issue> issues = new ArrayList<>();

        issues.add(new Issue("임시 타이틀"));

        return issues;
    }
}
