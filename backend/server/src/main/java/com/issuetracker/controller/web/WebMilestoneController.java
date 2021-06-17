package com.issuetracker.controller.web;

import com.issuetracker.dto.web.WebMilestonesDto;
import com.issuetracker.service.web.WebMilestoneService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebMilestoneController {

    private final WebMilestoneService milestoneService;

    public WebMilestoneController(WebMilestoneService milestoneService) {
        this.milestoneService = milestoneService;
    }

    @GetMapping("/milestones")
    public WebMilestonesDto getMilestoneList() {
        return milestoneService.findAll();
    }

}
