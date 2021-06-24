package com.issuetracker.repository;

import com.issuetracker.domain.*;
import com.issuetracker.domain.auth.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class IssueRepository {
    private static final Logger logger = LoggerFactory.getLogger(IssueRepository.class.getName());

    private static final String ISSUE_SQL = "SELECT issue.id, issue.title, issue.content, issue.statusId, issue.createdDate, "
            + "user.name, user.profileImageUrl, "
            + "milestone.title AS milestoneTitle, milestone.description AS milestoneDescription, milestone.dueDate AS milestoneDueDate "
            + "FROM issue "
            + "INNER JOIN user ON issue.writerId = user.id "
            + "LEFT JOIN milestone ON issue.milestoneId = milestone.id ";

    private final NamedParameterJdbcTemplate jdbc;

    public IssueRepository(NamedParameterJdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Issues getIssues(User _, IssueStatus status) {
        if (status == IssueStatus.ALL) {
            return getAllIssues();
        }

        String sql = ISSUE_SQL + "WHERE issue.statusId = :statusId ";
        Map<String, String> params = Collections.singletonMap("statusId", status.name());

        return new Issues(jdbc.query(sql, params, issueMapper));
    }

    private Issues getAllIssues() {
        return new Issues(jdbc.query(ISSUE_SQL, Collections.emptyMap(), issueMapper));
    }

    private final RowMapper issueMapper = (rs, rowNum) -> {
        Long issueId = rs.getLong("id");

        Assignees assignees = getAssignees(issueId);
        Labels labels = getLabels(issueId);

        String milestoneTitle = rs.getString("milestoneTitle");
        MilestoneInfo milestoneInfo = milestoneTitle != null ? new MilestoneInfo(
                milestoneTitle,
                rs.getString("milestoneDescription"),
                rs.getTimestamp("milestoneDueDate").toLocalDateTime()
        ) : null;

        Writer writer = new Writer(rs.getString("name"), rs.getString("profileImageUrl"));

        return new Issue(
                issueId,
                milestoneInfo,
                rs.getString("title"),
                rs.getString("content"),
                IssueStatus.from(rs.getString("statusId")),
                writer,
                rs.getTimestamp("createdDate").toLocalDateTime(),
                assignees,
                labels
        );
    };

    private Assignees getAssignees(Long issueId) {
        String sql = "SELECT user.id, user.name, user.profileImageUrl "
                + "FROM user "
                + "INNER JOIN assignee ON assignee.userId = user.id "
                + "WHERE assignee.issueId = :issueId";

        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        return new Assignees(jdbc.query(sql, params, (rs, rowNum) -> {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String profileImageUrl = rs.getString("profileImageUrl");
            return new Assignee(id, name, profileImageUrl);
        }));
    }

    private Labels getLabels(Long issueId) {
        String sql = "SELECT label.id, label.title, label.description, label.backgroundColor, label.textColor "
                + "FROM label "
                + "INNER JOIN issueLabel ON issueLabel.labelId = label.id "
                + "WHERE issueLabel.issueId = :issueId";

        Map<String, Long> params = Collections.singletonMap("issueId", issueId);

        return new Labels(jdbc.query(sql, params, (rs, rowNum) -> {
            Long id = rs.getLong("id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            String backgroundColor = rs.getString("backgroundColor");
            String textColor = rs.getString("textColor");
            return new Label(id, title, description, backgroundColor, textColor);
        }));
    }

    // 이슈의 status를 토글하는 기능을 만들고자 했음. on/off
    // DTO 나중에 없애기
    public void toggle(IssuesNumbers issueNumbers) {
    }

    public IssueOption findIssueOption() {
        Writer writer = new Writer("네오", "http://testProfile.image.url");

        Assignees assignees = new Assignees(Arrays.asList(
                new Assignee("noel", "노을", "http://testProfile.image.url"),
                new Assignee("pyro", "파이로", "http://testProfile.image.url")
        ));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀4", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀5", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀6", "라벨 설명3", "#FF0000", "#000000"));

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());
        Issues issues = new Issues();
        issues.add(new Issue(2L, milestoneInfo, "열린 이슈 타이틀1", "열린 이슈 설명1", IssueStatus.OPEN, writer, LocalDateTime.now(), assignees, labels));
        issues.add(new Issue(3L, milestoneInfo, "열린 이슈 타이틀2", "열린 이슈 설명2", IssueStatus.OPEN, writer, LocalDateTime.now(), assignees, labels));


        Milestones milestones = new Milestones();
        milestones.add(new Milestone(1L, issues, milestoneInfo));

        return new IssueOption(assignees, labels, milestones);
    }

    public void save(NewIssue issue) {
        logger.debug(issue.toString());
    }

    public Issue findById(Long issueId) {
        Writer writer = new Writer("네오", "http://testProfile.image.url");

        Assignees assignees = new Assignees(Arrays.asList(
                new Assignee("noel", "노을", "http://testProfile.image.url"),
                new Assignee("pyro", "파이로", "http://testProfile.image.url")
        ));

        Labels labels = new Labels();
        labels.add(new Label(1L, "라벨 타이틀1", "라벨 설명1", "#FF0000", "#000000"));
        labels.add(new Label(2L, "라벨 타이틀2", "라벨 설명2", "#FF0000", "#000000"));
        labels.add(new Label(3L, "라벨 타이틀3", "라벨 설명3", "#FF0000", "#000000"));


        List<Long> issuesId = new ArrayList<>();
        issuesId.add(1L);
        issuesId.add(2L);
        issuesId.add(3L);

        MilestoneInfo milestoneInfo = new MilestoneInfo("마일스톤 제목1", "마일스톤 내용1", LocalDateTime.now());

        Issue issue = new Issue(issueId, milestoneInfo, "검색한 이슈 타이틀1", "닫힌 이슈 설명1", IssueStatus.CLOSED, writer, LocalDateTime.now(), assignees, labels);

        return issue;
    }

}
