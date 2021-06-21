package com.issuetracker.service.github;

import com.issuetracker.dto.auth.*;
import com.issuetracker.exception.GitHubException;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import static org.springframework.http.HttpHeaders.ACCEPT;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

public abstract class GitHubService {
    private static final String GITHUB_ACCESS_TOKEN_URI = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_USER_URI = "https://api.github.com/user";
    private static final String GITHUB_EMAIL_URI = "https://api.github.com/user/emails";

    private static final WebClient accessTokenClient = WebClient.builder()
            .baseUrl(GITHUB_ACCESS_TOKEN_URI)
            .defaultHeader(ACCEPT, APPLICATION_JSON_VALUE)
            .build();
    private static final WebClient userClient = WebClient.builder()
            .baseUrl(GITHUB_USER_URI)
            .defaultHeader(ACCEPT, APPLICATION_JSON_VALUE)
            .build();
    private static final WebClient emailClient = WebClient.builder()
            .baseUrl(GITHUB_EMAIL_URI)
            .defaultHeader(ACCEPT, APPLICATION_JSON_VALUE)
            .build();

    abstract String getClientId();

    abstract String getClientSecret();

    public AccessTokenResponse getAccessToken(String code) {
        try {
            return accessTokenClient.post()
                    .bodyValue(new AccessTokenRequest(getClientId(), getClientSecret(), code))
                    .retrieve()
                    .bodyToMono(AccessTokenResponse.class)
                    .block();
        } catch (Exception e) {
            throw new GitHubException("Access Token 획득 실패");
        }
    }

    // NOTE: https://www.baeldung.com/spring-webclient-simultaneous-calls
    public UserDto getUser(String accessToken) {
        try {
            Tuple2<UserInfoDto, UserEmailDto[]> response = Mono.zip(requestUserInfo(accessToken), requestUserEmails(accessToken)).block();
            return UserDto.from(response.getT1(), response.getT2());
        } catch (Exception e) {
            throw new GitHubException("유저 획득 실패");
        }
    }

    private Mono<UserInfoDto> requestUserInfo(String accessToken) {
        return userClient.get()
                .header(AUTHORIZATION, "token " + accessToken)
                .retrieve().bodyToMono(UserInfoDto.class);
    }

    private Mono<UserEmailDto[]> requestUserEmails(String accessToken) {
        return emailClient.get()
                .header(AUTHORIZATION, "token " + accessToken)
                .retrieve().bodyToMono(UserEmailDto[].class);
    }
}
