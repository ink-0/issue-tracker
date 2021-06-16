package com.issuetracker.domain;

public class Label {
    private final String title;

    private final String description;

    private final String backgroundColorHexa;

    private final String textColorHexa;

    public Label(String title, String description, String backgroundColorHexa, String textColorHexa) {
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
}
