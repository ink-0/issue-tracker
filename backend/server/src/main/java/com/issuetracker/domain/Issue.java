package com.issuetracker.domain;

public class Issue {
    public Issue(String title) {
        this.title = title;
    }

    private final String title;

    public String getTitle() {
        return title;
    }
}
