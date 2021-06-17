package com.issuetracker.dto.web;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.dto.auth.UserDto;

import java.time.LocalDateTime;

public class WebIssueDetailDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private boolean status;

    private UserDto writer;

    private LocalDateTime createdDateTime;

    private WebAssigneesDto assignees;

    private WebLabelsDto labels;

    private WebCommentsDto comments;

    public static WebIssueDetailDto from(Issue issue, Comments comments) {
        return new WebIssueDetailDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), issue.isStatus(), UserDto.from(issue.getWriter()), issue.getCreatedDateTime(), WebAssigneesDto.from(issue.getAssignees()), WebLabelsDto.from(issue.getLabels()), WebCommentsDto.from(comments));
    }

    public WebIssueDetailDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, boolean status, UserDto writer, LocalDateTime createdDateTime, WebAssigneesDto assignees, WebLabelsDto labels, WebCommentsDto comments) {
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

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(MilestoneInfo milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public UserDto getWriter() {
        return writer;
    }

    public void setWriter(UserDto writer) {
        this.writer = writer;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public WebAssigneesDto getAssignees() {
        return assignees;
    }

    public void setAssignees(WebAssigneesDto assignees) {
        this.assignees = assignees;
    }

    public WebLabelsDto getLabels() {
        return labels;
    }

    public void setLabels(WebLabelsDto labels) {
        this.labels = labels;
    }

    public WebCommentsDto getComments() {
        return comments;
    }

    public void setComments(WebCommentsDto comments) {
        this.comments = comments;
    }
}
