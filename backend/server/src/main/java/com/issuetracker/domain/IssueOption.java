package com.issuetracker.domain;

import com.issuetracker.domain.auth.Users;

public class IssueOption {

    private final Users assignees;

    private final Labels labels;

    private final Milestones milestones;

    public IssueOption(Users assignees, Labels labels, Milestones milestones) {
        this.assignees = assignees;
        this.labels = labels;
        this.milestones = milestones;
    }

    public Users getAssignees() {
        return assignees;
    }

    public Labels getLabels() {
        return labels;
    }

    public Milestones getMilestones() {
        return milestones;
    }
}
