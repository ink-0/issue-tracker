package com.issuetracker.controller;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.dto.*;
import com.issuetracker.dto.auth.*;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.GitHubService;
import com.issuetracker.service.UserService;
import com.issuetracker.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api")
public class AuthController {
    private final GitHubService gitHubService;
    private final UserService userService;
    private final AuthService authService;

    public AuthController(GitHubService gitHubService, UserService userService, AuthService authService) {
        this.gitHubService = gitHubService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/hello")
    @LoginRequired
    public MessageResponse getHello(HttpServletRequest request) {
        UserDto userDto = (UserDto) request.getAttribute("user");
        authService.authenticate(userDto);
        return new MessageResponse("안녕하세요! 로그인 한 유저는 언제나 환영합니다!");
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        String code = authRequest.getCode();

        AccessTokenResponse accessTokenResponse = gitHubService.getAccessToken(code);
        String accessToken = accessTokenResponse.getAccessToken();

        UserDto userDto = gitHubService.getUser(accessToken);
        userService.save(userDto);
        authService.save(userDto, accessTokenResponse);

        return ResponseEntity.status(CREATED)
                .body(new AuthResponse(JwtUtil.createJwt(userDto)));
    }
}
