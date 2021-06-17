package com.issuetracker.domain;

import java.time.LocalDateTime;

public class MilestoneInfo {

    private final String title;

    private final String description;

    private final LocalDateTime dueDate;

    public MilestoneInfo(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }
}
