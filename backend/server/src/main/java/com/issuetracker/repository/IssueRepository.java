package com.issuetracker.repository;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.Issues;
import com.issuetracker.domain.Label;
import com.issuetracker.domain.Labels;
import com.issuetracker.domain.auth.User;
import com.issuetracker.domain.auth.Users;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class IssueRepository {
    public Issues getOpenIssues(User writer) {
        writer = new User("neo@test.com", "네오", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("noel@test.com", "노을", "http://testProfile.image.url"));
        assignees.add(new User("pyro@test.com", "파이로", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label("라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label("라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label("라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        Issues issues = new Issues();
        issues.add(new Issue(2L, "열린 이슈 타이틀1", "열린 이슈 설명1", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, "열린 이슈 타이틀2", "열린 이슈 설명2", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(4L, "열린 이슈 타이틀3", "열린 이슈 설명3", true, writer, LocalDateTime.now(), assignees, labels));

        return issues;
    }

    public Issues getClosedIssues(User writer) {
        writer = new User("test@test.com", "테스터", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("assign@test.com", "담당자", "http://testProfile.image.url"));
        assignees.add(new User("assign2@test.com", "담당자2", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label("라벨 타이틀1", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label("라벨 타이틀2", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label("라벨 타이틀3", "라벨 설명3", "#FF0000", "#000000"));

        Issues issues = new Issues();
        issues.add(new Issue(1L, "닫힌 이슈 타이틀1", "닫힌 이슈 설명1", false, writer, LocalDateTime.now(), assignees, labels));

        return issues;
    }
}
