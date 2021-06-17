package com.issuetracker.repository;

import com.issuetracker.domain.*;
import com.issuetracker.domain.auth.User;
import com.issuetracker.domain.auth.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

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

        Milestone milestone = new Milestone(1L, "마일스톤 제목1", "마일스톤 내용", LocalDateTime.now());
        Milestone milestone2 = new Milestone(2L, "마일스톤 제목2", "마일스톤 내용", LocalDateTime.now());
        Milestone milestone3 = new Milestone(3L, "마일스톤 제목3", "마일스톤 내용", LocalDateTime.now());


        Issues issues = new Issues();
        issues.add(new Issue(2L, milestone, "열린 이슈 타이틀1", "열린 이슈 설명1", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, milestone2, "열린 이슈 타이틀2", "열린 이슈 설명2", true, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(4L, milestone3, "열린 이슈 타이틀3", "열린 이슈 설명3", true, writer, LocalDateTime.now(), assignees, labels));

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

        Milestone milestone = new Milestone(1L, "마일스톤 제목1", "마일스톤 내용", LocalDateTime.now());
        Issues issues = new Issues();
        issues.add(new Issue(1L, milestone, "닫힌 이슈 타이틀1", "닫힌 이슈 설명1", false, writer, LocalDateTime.now(), assignees, labels));

        return issues;
    }

    // 이슈의 status를 토글하는 기능을 만들고자 했음. on/off
    // DTO 나중에 없애기
    public void toggle(IssuesNumber issueNumbers) {
    }

    public IssueOption findIssueOption() {

        Users assignees = new Users();
        assignees.add(new User("noel@test.com", "노을", "http://testProfile.image.url"));
        assignees.add(new User("pyro@test.com", "파이로", "http://testProfile.image.url"));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));


        Milestones milestones = new Milestones();
        milestones.add(new Milestone(1L, "마일스톤1", "마일스톤 내용", LocalDateTime.now()));
        milestones.add(new Milestone(2L, "마일스톤2", "마일스톤 내용", LocalDateTime.now()));
        milestones.add(new Milestone(3L, "마일스톤3", "마일스톤 내용", LocalDateTime.now()));

        return new IssueOption(assignees, labels, milestones);
    }

    public void save(NewIssue issue) {
        logger.debug(issue.toString());
    }
}
