package com.issuetracker.domain;

public enum IssueStatus {
    OPEN,
    CLOSED,
    ALL;

    public static IssueStatus from(String status) {
        return valueOf(status.toUpperCase());
    }
}
