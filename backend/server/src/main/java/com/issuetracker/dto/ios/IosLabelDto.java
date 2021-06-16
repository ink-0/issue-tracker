package com.issuetracker.dto.ios;

import com.issuetracker.domain.Label;

public class IosLabelDto {

    private String title;

    private String description;

    private String backgroundColorHexa;

    private String textColorHexa;

    public IosLabelDto(String title, String description, String backgroundColorHexa, String textColorHexa) {
        this.title = title;
        this.description = description;
        this.backgroundColorHexa = backgroundColorHexa;
        this.textColorHexa = textColorHexa;
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

    public String getBackgroundColorHexa() {
        return backgroundColorHexa;
    }

    public void setBackgroundColorHexa(String backgroundColorHexa) {
        this.backgroundColorHexa = backgroundColorHexa;
    }

    public String getTextColorHexa() {
        return textColorHexa;
    }

    public void setTextColorHexa(String textColorHexa) {
        this.textColorHexa = textColorHexa;
    }

    public static IosLabelDto from(Label label) {
        return new IosLabelDto(label.getTitle(), label.getDescription(), label.getBackgroundColorHexa(), label.getTextColorHexa());
    }

}