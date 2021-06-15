package com.issuetracker.controller.ios;

import com.issuetracker.annotation.UserAttribute;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.IosIssueDto;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.ios.IosIssueService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    // @LoginRequired
    public List<IosIssueDto> getIssues(@UserAttribute UserDto user) {
        // authService.authenticate(user);
        // return iosIssueService.getIssues(user);
        return iosIssueService.getIssues(new UserDto("", "", ""));
    }
}
