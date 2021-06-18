package com.issuetracker.dto.web;

import com.issuetracker.domain.Labels;

import java.util.List;
import java.util.stream.Collectors;

public class WebLabelsDto {

    private final List<WebLabelDto> labels;

    public WebLabelsDto(List<WebLabelDto> labels) {
        this.labels = labels;
    }

    public static WebLabelsDto from(Labels labels) {
        return new WebLabelsDto(labels.toList().stream().map(WebLabelDto::from).collect(Collectors.toList()));
    }

    public List<WebLabelDto> toList() {
        return labels;
    }

    public Labels toLabels() {
        return new Labels(labels.stream()
                .map(WebLabelDto::toLabel)
                .collect(Collectors.toList()));
    }

    public List<WebLabelDto> getLabels() {
        return labels;
    }
}
