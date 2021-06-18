package com.issuetracker.controller.ios;

import com.issuetracker.dto.ios.IosMilestonesDto;
import com.issuetracker.service.ios.IosMilestoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ios")
public class IosMilestoneController {

    private final IosMilestoneService milestoneService;

    public IosMilestoneController(IosMilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/milestones")
    public IosMilestonesDto getMilestoneList() {
        return milestoneService.findAll();
    }

}
