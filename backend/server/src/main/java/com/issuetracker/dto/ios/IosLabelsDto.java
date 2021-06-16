package com.issuetracker.dto.ios;

import com.issuetracker.domain.Labels;

import java.util.List;
import java.util.stream.Collectors;

public class IosLabelsDto {

    private final List<IosLabelDto> labelsDto;

    public IosLabelsDto(List<IosLabelDto> labelsDto) {
        this.labelsDto = labelsDto;
    }

    public static IosLabelsDto from(Labels labels) {
        return new IosLabelsDto(labels.toList().stream().map(IosLabelDto::from).collect(Collectors.toList()));
    }

    public List<IosLabelDto> getLabelsDto() {
        return labelsDto;
    }
}
