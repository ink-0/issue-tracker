package com.issuetracker.controller.web;

import com.issuetracker.annotation.UserAttribute;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.web.WebIssueDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.web.WebIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    // @LoginRequired
    public List<WebIssueDto> getIssues(@UserAttribute UserDto user) {
        // authService.authenticate(user);
        // return iosIssueService.getIssues(user);
        return webIssueService.getIssues(new UserDto("", "", ""));
    }
}
