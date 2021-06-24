package com.issuetracker.controller.ios;

import com.issuetracker.dto.ios.IosLabelsDto;
import com.issuetracker.service.ios.IosLabelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ios")
public class IosLabelController {

    private final IosLabelService iosLabelService;

    public IosLabelController(IosLabelService iosLabelService) {
        this.iosLabelService = iosLabelService;
    }

    @GetMapping("/labels")
    public IosLabelsDto findLabels(){
        return iosLabelService.findAll();
    }

}
