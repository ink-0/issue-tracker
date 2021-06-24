package com.issuetracker.domain;

public class NewIssue {

    private final String title;

    private final String comment;

    private final Assignees assignees;

    private final Labels labels;

    private final Long milestoneId;

    public NewIssue(String title, String comment, Assignees assignees, Labels labels, Long milestoneId) {
        this.title = title;
        this.comment = comment;
        this.assignees = assignees;
        this.labels = labels;
        this.milestoneId = milestoneId;
    }

    public String getTitle() {
        return title;
    }

    public String getComment() {
        return comment;
    }

    public Assignees getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
