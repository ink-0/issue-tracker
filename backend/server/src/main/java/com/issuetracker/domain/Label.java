package com.issuetracker.domain;

import org.springframework.data.annotation.Id;

public class Label {

    @Id
    private final Long id;

    private final String title;

    private final String description;

    private final String backgroundColorHexa;

    private final String textColorHexa;

    public Label(Long id, String title, String description, String backgroundColorHexa, String textColorHexa) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColorHexa = backgroundColorHexa;
        this.textColorHexa = textColorHexa;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundColorHexa() {
        return backgroundColorHexa;
    }

    public String getTextColorHexa() {
        return textColorHexa;
    }

    public Long getId() {
        return id;
    }
}
