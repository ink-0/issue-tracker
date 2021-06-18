package com.issuetracker.dto.ios;

import com.issuetracker.domain.Labels;

import java.util.List;
import java.util.stream.Collectors;

public class IosLabelsDto {

    private final List<IosLabelDto> labels;

    public IosLabelsDto(List<IosLabelDto> labels) {
        this.labels = labels;
    }

    public static IosLabelsDto from(Labels labels) {
        return new IosLabelsDto(labels.toList().stream().map(IosLabelDto::from).collect(Collectors.toList()));
    }

    public List<IosLabelDto> toList() {
        return labels;
    }

    public Labels toLabels() {
        return new Labels(labels.stream()
                .map(IosLabelDto::toLabel)
                .collect(Collectors.toList()));
    }

    public List<IosLabelDto> getLabels() {
        return labels;
    }
}
