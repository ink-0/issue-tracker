package com.issuetracker.domain;

public class IssuesNumber {

    private final Long[] issueNumber;

    public IssuesNumber(Long[] issueNumber) {
        this.issueNumber = issueNumber;
    }

    public Long[] getIssueNumber() {
        return issueNumber;
    }
}
