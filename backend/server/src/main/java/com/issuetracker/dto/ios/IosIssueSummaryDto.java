package com.issuetracker.dto.ios;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.dto.IssueStatusDto;
import com.issuetracker.dto.auth.UserDto;

import java.time.LocalDateTime;
import java.util.List;

public class IosIssueSummaryDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private IssueStatusDto status;

    private UserDto writer;

    private LocalDateTime createdDateTime;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    public IosIssueSummaryDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, IssueStatusDto status, UserDto writer, LocalDateTime createdDateTime, IosAssigneesDto assignees, IosLabelsDto labels) {
        this.issueId = issueId;
        this.milestoneInfo = milestoneInfo;
        this.title = title;
        this.content = content;
        this.status = status;
        this.writer = writer;
        this.createdDateTime = createdDateTime;
        this.assignees = assignees;
        this.labels = labels;
    }

    public static IosIssueSummaryDto from(Issue issue) {
        return new IosIssueSummaryDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), IssueStatusDto.from(issue.getStatus()), UserDto.from(issue.getWriter()), issue.getCreatedDateTime(), IosAssigneesDto.from(issue.getAssignees()), IosLabelsDto.from(issue.getLabels()));
    }

    public Long getIssueId() {
        return issueId;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getStatus() {
        return status.toString();
    }

    public UserDto getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public List<UserDto> getAssignees() {
        return assignees.getUsers();
    }

    public List<IosLabelDto> getLabels() {
        return labels.getLabels();
    }
}
