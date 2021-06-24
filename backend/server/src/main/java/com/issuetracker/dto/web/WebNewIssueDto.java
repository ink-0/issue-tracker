package com.issuetracker.dto.web;

import com.issuetracker.domain.NewIssue;

import java.util.List;

public class WebNewIssueDto {

    private String title;

    private String comment;

    private WebAssigneesDto assignees;

    private WebLabelsDto labels;

    private Long milestoneId;

    public WebNewIssueDto(String title, String comment, WebAssigneesDto assignees, WebLabelsDto labels, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assignees = assignees;
        this.labels = labels;
        this.milestoneId = milestoneId;
    }

    public static WebNewIssueDto from(NewIssue newIssue) {
        return new WebNewIssueDto(newIssue.getTitle(), newIssue.getComment(), WebAssigneesDto.from(newIssue.getAssignees()), WebLabelsDto.from(newIssue.getLabels()), newIssue.getMilestoneId());
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assignees.toAssignees(), labels.toLabels(), milestoneId);
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public List<WebAssigneeDto> getAssignees() {
        return assignees.toList();
    }

    public List<WebLabelDto> getLabels() {
        return labels.toList();
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
