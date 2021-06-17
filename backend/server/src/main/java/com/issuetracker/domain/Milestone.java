package com.issuetracker.domain;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class Milestone {

    @Id
    private final Long id;

    private final String title;

    private final String description;

    private final LocalDateTime dueDate;

    public Milestone(Long id, String title, String description, LocalDateTime dueDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
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
