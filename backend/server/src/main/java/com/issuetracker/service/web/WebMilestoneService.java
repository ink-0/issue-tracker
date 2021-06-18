package com.issuetracker.service.web;

import com.issuetracker.dto.web.WebMilestonesDto;
import com.issuetracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

@Service
public class WebMilestoneService {

    private final MilestoneRepository milestoneRepository;

    public WebMilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public WebMilestonesDto findAll() {
        return WebMilestonesDto.from(milestoneRepository.findAll());
    }

}
