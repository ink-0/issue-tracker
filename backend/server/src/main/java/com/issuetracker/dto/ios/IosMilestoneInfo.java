package com.issuetracker.dto.ios;

import com.issuetracker.domain.MilestoneInfo;

import java.time.LocalDateTime;

public class IosMilestoneInfo {

    private String title;

    private String description;

    private LocalDateTime dueDate;

    public IosMilestoneInfo(String title, String description, LocalDateTime dueDate) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static IosMilestoneInfo from(MilestoneInfo milestoneInfo){
        return new IosMilestoneInfo(milestoneInfo.getTitle(),milestoneInfo.getDescription(),milestoneInfo.getDueDate());
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
