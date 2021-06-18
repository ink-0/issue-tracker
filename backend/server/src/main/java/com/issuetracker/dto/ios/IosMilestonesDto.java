package com.issuetracker.dto.ios;

import com.issuetracker.domain.Milestones;

import java.util.List;
import java.util.stream.Collectors;

public class IosMilestonesDto {

    private final List<IosMilestoneDto> milestones;

    public IosMilestonesDto(List<IosMilestoneDto> milestones) {
        this.milestones = milestones;
    }

    public static IosMilestonesDto from(Milestones milestones) {
        return new IosMilestonesDto(milestones.toList().stream().map(IosMilestoneDto::from).collect(Collectors.toList()));
    }

    public List<IosMilestoneDto> getMilestones() {
        return milestones;
    }
}
