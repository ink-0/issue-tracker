package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.dto.IssueStatusDto;

import java.time.LocalDateTime;

public class IosIssueDetailDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private IssueStatusDto status;

    private IosIssueWriterDto writer;

    private LocalDateTime createdDateTime;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    private IosCommentsDto comments;

    public IosIssueDetailDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, IssueStatusDto status, IosIssueWriterDto writer, LocalDateTime createdDateTime, IosAssigneesDto assignees, IosLabelsDto labels, IosCommentsDto comments) {
        this.issueId = issueId;
        this.milestoneInfo = milestoneInfo;
        this.title = title;
        this.content = content;
        this.status = status;
        this.writer = writer;
        this.createdDateTime = createdDateTime;
        this.assignees = assignees;
        this.labels = labels;
        this.comments = comments;
    }

    public static IosIssueDetailDto from(Issue issue, Comments comments) {
        return new IosIssueDetailDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), IssueStatusDto.from(issue.getStatus()), IosIssueWriterDto.from(issue.getWriter()), issue.getCreatedDateTime(), IosAssigneesDto.from(issue.getAssignees()), IosLabelsDto.from(issue.getLabels()), IosCommentsDto.from(comments));
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

    public IssueStatusDto getStatus() {
        return status;
    }

    public IosIssueWriterDto getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public IosAssigneesDto getAssignees() {
        return assignees;
    }

    public IosLabelsDto getLabels() {
        return labels;
    }

    public IosCommentsDto getComments() {
        return comments;
    }
}
