package com.issuetracker.repository;

import com.issuetracker.domain.*;
import com.issuetracker.domain.auth.User;
import com.issuetracker.domain.auth.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class IssueRepository {

    Logger logger = LoggerFactory.getLogger(IssueRepository.class.getName());

    public Issues getOpenIssues(User writer) {
        writer = new User("neo@test.com", "네오", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("noel@test.com", "노을", "http://testProfile.image.url"));
        assignees.add(new User("pyro@test.com", "파이로", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());
        MilestoneInfo milestoneInfo2 = new MilestoneInfo("마일스톤 제목2", "마일스톤 내용2", LocalDateTime.now());

        Issues issues = new Issues();
        issues.add(new Issue(2L, milestoneInfo, "열린 이슈 타이틀1", "열린 이슈 설명1", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, milestoneInfo2, "열린 이슈 타이틀2", "열린 이슈 설명2", true, writer, LocalDateTime.now(), assignees, labels));

        return issues;
    }

    public Issues getClosedIssues(User writer) {
        writer = new User("test@test.com", "테스터", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("assign@test.com", "담당자", "http://testProfile.image.url"));
        assignees.add(new User("assign2@test.com", "담당자2", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀1", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀2", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀3", "라벨 설명3", "#FF0000", "#000000"));


        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());

        Issues issues = new Issues();
        issues.add(new Issue(1L, milestoneInfo, "닫힌 이슈 타이틀1", "닫힌 이슈 설명1", false, writer, LocalDateTime.now(), assignees, labels));

        Milestone milestone = new Milestone(1L, issues, milestoneInfo);

        return issues;
    }

    public Issues getAllIssues(User writer) {
        writer = new User("honux@test.com", "호눅스", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("k@test.com", "K", "http://testProfile.image.url"));
        assignees.add(new User("pyro@test.com", "파이로", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());
        MilestoneInfo milestoneInfo2 = new MilestoneInfo("마일스톤 제목2", "마일스톤 내용2", LocalDateTime.now());

        Issues issues = new Issues();
        issues.add(new Issue(2L, milestoneInfo, "열린 이슈 타이틀1", "열린 이슈 설명1", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, milestoneInfo2, "열린 이슈 타이틀2", "열린 이슈 설명2", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(4L, milestoneInfo2, "닫힌 이슈 타이틀1", "닫힌 이슈 설명", false, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(5L, milestoneInfo2, "닫힌 이슈 타이틀2", "닫힌 이슈 설명", false, writer, LocalDateTime.now(), assignees, labels));

        return issues;

    }


    // 이슈의 status를 토글하는 기능을 만들고자 했음. on/off
    // DTO 나중에 없애기
    public void toggle(IssuesNumbers issueNumbers) {
    }

    public IssueOption findIssueOption() {
        User writer = new User("test@test.com", "테스터", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("noel@test.com", "노을", "http://testProfile.image.url"));
        assignees.add(new User("pyro@test.com", "파이로", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());
        Issues issues = new Issues();
        issues.add(new Issue(2L, milestoneInfo, "열린 이슈 타이틀1", "열린 이슈 설명1", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, milestoneInfo, "열린 이슈 타이틀2", "열린 이슈 설명2", true, writer, LocalDateTime.now(), assignees, labels));


        Milestones milestones = new Milestones();
        milestones.add(new Milestone(1L, issues, milestoneInfo));

        return new IssueOption(assignees, labels, milestones);
    }

    public void save(NewIssue issue) {
        logger.debug(issue.toString());
    }

    public Issue findById(Long issueId) {

        User writer = new User("test@test.com", "테스터", "http://testProfile.image.url");

        Users assignees = new Users();
        assignees.add(new User("assign@test.com", "담당자", "http://testProfile.image.url"));
        assignees.add(new User("assign2@test.com", "담당자2", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀1", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀2", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀3", "라벨 설명3", "#FF0000", "#000000"));


        List<Long> issuesId = new ArrayList<>();
        issuesId.add(1L);
        issuesId.add(2L);
        issuesId.add(3L);

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());

        Issue issue = new Issue(issueId, milestoneInfo, "검색한 이슈 타이틀1", "닫힌 이슈 설명1", false, writer, LocalDateTime.now(), assignees, labels);

        return issue;
    }

}
