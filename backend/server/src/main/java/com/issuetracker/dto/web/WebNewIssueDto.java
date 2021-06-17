package com.issuetracker.dto.web;

import com.issuetracker.domain.NewIssue;

public class WebNewIssueDto {

    private String title;

    private String comment;

    private Long[] assigneesId;

    private Long[] labelsId;

    private Long milestoneId;

    public WebNewIssueDto(String title, String comment, Long[] assigneesId, Long[] labelsId, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assigneesId = assigneesId;
        this.labelsId = labelsId;
        this.milestoneId = milestoneId;
    }

    public NewIssue toNewIssue() {
        return new NewIssue(title, comment, assigneesId, labelsId, milestoneId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long[] getAssigneesId() {
        return assigneesId;
    }

    public void setAssigneesId(Long[] assigneesId) {
        this.assigneesId = assigneesId;
    }

    public Long[] getLabelsId() {
        return labelsId;
    }

    public void setLabelsId(Long[] labelsId) {
        this.labelsId = labelsId;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Long milestoneId) {
        this.milestoneId = milestoneId;
    }
}
