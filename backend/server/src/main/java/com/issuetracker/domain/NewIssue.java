package com.issuetracker.domain;

import com.issuetracker.domain.auth.Users;

public class NewIssue {

    private final String title;

    private final String comment;

    private final Users assignees;

    private final Labels labels;

    private final Long milestoneId;

    public NewIssue(String title, String comment, Users assignees, Labels labels, Long milestoneId) {
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

    public Users getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public Long getMilestoneId() {
        return milestoneId;
    }
}
