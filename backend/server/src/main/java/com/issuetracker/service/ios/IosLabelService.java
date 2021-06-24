package com.issuetracker.service.ios;

import com.issuetracker.dto.ios.IosLabelDto;
import com.issuetracker.dto.ios.IosLabelsDto;
import com.issuetracker.repository.LabelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IosLabelService {
    private final LabelRepository labelRepository;

    public IosLabelService(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    public IosLabelsDto findAll() {
        List<IosLabelDto> labels = labelRepository.findAll().stream().map(IosLabelDto::from).collect(Collectors.toList());
        return new IosLabelsDto(labels);
    }
}
