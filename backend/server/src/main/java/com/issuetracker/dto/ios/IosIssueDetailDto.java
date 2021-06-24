package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class IosIssueDetailDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private String status;

    private IosWriterDto writer;

    private LocalDateTime createdDateTime;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    private IosCommentsDto comments;

    public IosIssueDetailDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, String status, IosWriterDto writer, LocalDateTime createdDateTime, IosAssigneesDto assignees, IosLabelsDto labels, IosCommentsDto comments) {
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
        return new IosIssueDetailDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), issue.getStatus().name(), IosWriterDto.from(issue.getWriter()), issue.getCreatedDateTime(), IosAssigneesDto.from(issue.getAssignees()), IosLabelsDto.from(issue.getLabels()), IosCommentsDto.from(comments));
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
        return status;
    }

    public IosWriterDto getWriter() {
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
