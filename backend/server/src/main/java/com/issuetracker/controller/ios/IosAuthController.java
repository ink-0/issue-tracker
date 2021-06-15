package com.issuetracker.controller.ios;

import com.issuetracker.annotation.LoginRequired;
import com.issuetracker.annotation.UserAttribute;
import com.issuetracker.dto.MessageResponse;
import com.issuetracker.dto.auth.*;
import com.issuetracker.service.AuthService;
import com.issuetracker.service.UserService;
import com.issuetracker.service.github.GitHubIosService;
import com.issuetracker.service.github.GitHubService;
import com.issuetracker.util.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/api/ios")
public class IosAuthController {
    private final GitHubService gitHubService;
    private final UserService userService;
    private final AuthService authService;

    public IosAuthController(GitHubIosService gitHubService, UserService userService, AuthService authService) {
        this.gitHubService = gitHubService;
        this.userService = userService;
        this.authService = authService;
    }

    @GetMapping("/hello")
    @LoginRequired
    public MessageResponse getHello(@UserAttribute UserDto user) {
        authService.authenticate(user);
        return new MessageResponse("안녕하세요, " + user.getName() + " 님!\n로그인 한 유저는 언제나 환영합니다!" + "\n이미지: " + user.getProfileImageUrl());
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
        String code = authRequest.getCode();

        AccessTokenResponse accessTokenResponse = gitHubService.getAccessToken(code);
        String accessToken = accessTokenResponse.getAccessToken();

        UserInfoDto userInfoDto = gitHubService.getUser(accessToken);
        UserEmailDto userEmailDto = gitHubService.getEmail(accessToken);

        UserDto userDto = UserDto.from(userInfoDto,userEmailDto);

        userService.save(userDto);
        authService.save(userDto, accessTokenResponse);

        return ResponseEntity.status(CREATED)
                .body(new AuthResponse(JwtUtil.createJwt(userDto)));
    }
}
