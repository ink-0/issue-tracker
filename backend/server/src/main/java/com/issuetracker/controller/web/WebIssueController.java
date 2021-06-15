package com.issuetracker.controller.web;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.WebIssuesDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.web.WebIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/web")
public class WebIssueController {

    private final AuthService authService;
    private final WebIssueService webIssueService;

    public WebIssueController(AuthService authService, WebIssueService webIssueService) {
        this.authService = authService;
        this.webIssueService = webIssueService;
    }

    @GetMapping("/issues")
    public WebIssuesDto getIssues() {
        return webIssueService.getIssues(new UserDto("", "", ""));
    }
}
