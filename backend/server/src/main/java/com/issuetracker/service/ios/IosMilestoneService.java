package com.issuetracker.service.ios;

import com.issuetracker.dto.ios.IosMilestonesDto;
import com.issuetracker.repository.MilestoneRepository;
import org.springframework.stereotype.Service;

@Service
public class IosMilestoneService {

    private final MilestoneRepository milestoneRepository;

    public IosMilestoneService(MilestoneRepository milestoneRepository) {
        this.milestoneRepository = milestoneRepository;
    }

    public IosMilestonesDto findAll() {
        return IosMilestonesDto.from(milestoneRepository.findAllMilestoneInfo());
    }

}
