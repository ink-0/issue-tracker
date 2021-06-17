package com.issuetracker.domain;

import java.util.Arrays;

public class NewIssue {

    private final String title;

    private final String comment;

    private final Long[] assigneesId;

    private final Long[] labelsId;

    private final Long milestoneId;

    public NewIssue(String title, String comment, Long[] assigneesId, Long[] labelsId, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assigneesId = assigneesId;
        this.labelsId = labelsId;
        this.milestoneId = milestoneId;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public Long[] getAssigneesId() {
        return assigneesId;
    }

    public Long[] getLabelsId() {
        return labelsId;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }

    @Override
    public String toString() {
        return "NewIssueDto{" +
                "title='" + title + '\'' +
                ", comment='" + comment + '\'' +
                ", assigneesId=" + Arrays.toString(assigneesId) +
                ", labelsId=" + Arrays.toString(labelsId) +
                ", milestoneId=" + milestoneId +
                '}';
    }
}
