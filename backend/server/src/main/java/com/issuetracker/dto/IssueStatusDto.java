package com.issuetracker.dto;

import com.issuetracker.domain.IssueStatus;

public enum IssueStatusDto {
    OPEN,
    CLOSED,
    ALL;

    public static IssueStatusDto from(IssueStatus status) {
        return valueOf(status.name().toUpperCase());
    }

    public IssueStatus toIssueStatus() {
        return IssueStatus.from(name());
    }
}
