package com.issuetracker.dto.web;

import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class WebMilestoneInfo {

    private String title;

    private String description;

    private LocalDateTime dueDate;

    public WebMilestoneInfo(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static WebMilestoneInfo from(MilestoneInfo milestoneInfo) {
        return new WebMilestoneInfo(milestoneInfo.getTitle(), milestoneInfo.getDescription(), milestoneInfo.getDueDate());
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
