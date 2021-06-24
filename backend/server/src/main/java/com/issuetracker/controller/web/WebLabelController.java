package com.issuetracker.controller.web;

import com.issuetracker.dto.web.WebLabelsDto;
import com.issuetracker.service.web.WebLabelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebLabelController {

    private final WebLabelService webLabelService;

    public WebLabelController(WebLabelService webLabelService) {
        this.webLabelService = webLabelService;
    }

    @GetMapping("/labels")
    public WebLabelsDto findLabels() {
        return webLabelService.findAll();
    }

}
