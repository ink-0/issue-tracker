package com.issuetracker.service.web;

import com.issuetracker.dto.web.WebLabelDto;
import com.issuetracker.dto.web.WebLabelsDto;
import com.issuetracker.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WebLabelService {
    private final LabelRepository labelRepository;

    public WebLabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public WebLabelsDto findAll() {
        List<WebLabelDto> labels = labelRepository.findAll().stream().map(WebLabelDto::from).collect(Collectors.toList());
        return new WebLabelsDto(labels);
    }
}
