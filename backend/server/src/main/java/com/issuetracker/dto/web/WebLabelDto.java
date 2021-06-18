package com.issuetracker.dto.web;

import com.issuetracker.domain.Label;

public class WebLabelDto {

    private Long id;

    private String title;

    private String description;

    private String backgroundColorHexa;

    private String textColorHexa;

    public WebLabelDto(Long id, String title, String description, String backgroundColorHexa, String textColorHexa) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColorHexa = backgroundColorHexa;
        this.textColorHexa = textColorHexa;
    }

    public static WebLabelDto from(Label label) {
        return new WebLabelDto(label.getId(), label.getTitle(), label.getDescription(), label.getBackgroundColorHexa(), label.getTextColorHexa());
    }

    public Label toLabel() {
        return new Label(id, title, description, backgroundColorHexa, textColorHexa);
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

    public String getBackgroundColorHexa() {
        return backgroundColorHexa;
    }

    public String getTextColorHexa() {
        return textColorHexa;
    }
}
