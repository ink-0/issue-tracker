package com.issuetracker.dto.web;

import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;
import java.util.List;

public class WebIssueSummaryDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private String status;

    private WebWriterDto writer;

    private LocalDateTime createdDateTime;

    private WebAssigneesDto assignees;

    private WebLabelsDto labels;

    public static WebIssueSummaryDto from(Issue issue) {
        return new WebIssueSummaryDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), issue.getStatus().name(), WebWriterDto.from(issue.getWriter()), issue.getCreatedDateTime(), WebAssigneesDto.from(issue.getAssignees()), WebLabelsDto.from(issue.getLabels()));
    }

    public WebIssueSummaryDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, String status, WebWriterDto writer, LocalDateTime createdDateTime, WebAssigneesDto assignees, WebLabelsDto labels) {
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

    public WebWriterDto getWriter() {
        return writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public List<WebAssigneeDto> getAssignees() {
        return assignees.toList();
    }

    public List<WebLabelDto> getLabels() {
        return labels.getLabels();
    }
}
