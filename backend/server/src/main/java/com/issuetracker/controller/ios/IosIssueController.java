package com.issuetracker.controller.ios;

import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssuesDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.ios.IosIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ios")
public class IosIssueController {

    private final AuthService authService;
    private final IosIssueService iosIssueService;

    public IosIssueController(AuthService authService, IosIssueService iosIssueService) {
        this.authService = authService;
        this.iosIssueService = iosIssueService;
    }

    @GetMapping("/issues")
    public IosIssuesDto getIssues(UserDto user, @RequestParam("status") String issueStatus) {
        return iosIssueService.getIssues(user, issueStatus);
    }

}
