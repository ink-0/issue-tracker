package com.issuetracker.dto.ios;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.MilestoneInfo;
import com.issuetracker.dto.auth.UserDto;

import java.time.LocalDateTime;

public class IosIssueDetailDto {

    private Long issueId;

    private MilestoneInfo milestoneInfo;

    private String title;

    private String content;

    private boolean status;

    private UserDto writer;

    private LocalDateTime createdDateTime;

    private IosAssigneesDto assignees;

    private IosLabelsDto labels;

    private IosCommentsDto comments;

    public IosIssueDetailDto(Long issueId, MilestoneInfo milestoneInfo, String title, String content, boolean status, UserDto writer, LocalDateTime createdDateTime, IosAssigneesDto assignees, IosLabelsDto labels, IosCommentsDto comments) {
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
        return new IosIssueDetailDto(issue.getIssueId(), issue.getMilestoneInfo(), issue.getTitle(), issue.getContent(), issue.isStatus(), UserDto.from(issue.getWriter()), issue.getCreatedDateTime(), IosAssigneesDto.from(issue.getAssignees()), IosLabelsDto.from(issue.getLabels()), IosCommentsDto.from(comments));
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
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

    public IosAssigneesDto getAssignees() {
        return assignees;
    }

    public void setAssignees(IosAssigneesDto assignees) {
        this.assignees = assignees;
    }

    public IosLabelsDto getLabels() {
        return labels;
    }

    public void setLabels(IosLabelsDto labels) {
        this.labels = labels;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public MilestoneInfo getMilestoneInfo() {
        return milestoneInfo;
    }

    public void setMilestoneInfo(MilestoneInfo milestoneInfo) {
        this.milestoneInfo = milestoneInfo;
    }

    public IosCommentsDto getComments() {
        return comments;
    }

    public void setComments(IosCommentsDto comments) {
        this.comments = comments;
    }
}
