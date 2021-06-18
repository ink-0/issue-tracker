package com.issuetracker.domain;

public class IssuesNumbers {

    private final Long[] issueNumbers;

    public IssuesNumbers(Long[] issueNumbers) {
        this.issueNumbers = issueNumbers;
    }

    public Long[] toList() {
        return issueNumbers;
    }
}
