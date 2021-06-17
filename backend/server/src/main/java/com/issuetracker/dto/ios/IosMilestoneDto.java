package com.issuetracker.dto.ios;

import com.issuetracker.domain.Milestone;

import java.time.LocalDateTime;

public class IosMilestoneDto {

    private Long id;

    private String title;

    private String description;

    private LocalDateTime dueDate;

    public IosMilestoneDto(Long id, String title, String description, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public static IosMilestoneDto from(Milestone milestone) {
        return new IosMilestoneDto(milestone.getId(), milestone.getTitle(), milestone.getDescription(), milestone.getDueDate());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
