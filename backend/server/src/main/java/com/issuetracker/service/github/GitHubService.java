package com.issuetracker.service.github;

import com.issuetracker.dto.auth.AccessTokenRequest;
import com.issuetracker.dto.auth.AccessTokenResponse;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.exception.GitHubException;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestTemplate;

public abstract class GitHubService {
    private static final String GITHUB_ACCESS_TOKEN_URI = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_USER_URI = "https://api.github.com/user";
    private static RestTemplate restTemplate = new RestTemplate();

    abstract String getClientId();

    abstract String getClientSecret();

    public AccessTokenResponse getAccessToken(String code) {
        RequestEntity<AccessTokenRequest> request = RequestEntity
                .post(GITHUB_ACCESS_TOKEN_URI)
                .header("Accept", "application/json")
                .body(new AccessTokenRequest(getClientId(), getClientSecret(), code));

        try {
            return restTemplate
                    .exchange(request, AccessTokenResponse.class)
                    .getBody();
        } catch (Exception e) {
            throw new GitHubException("Access Token 획득 실패");
        }
    }

    public UserDto getUser(String accessToken) {
        RequestEntity<Void> request = RequestEntity
                .get(GITHUB_USER_URI)
                .header("Accept", "application/json")
                .header("Authorization", "token " + accessToken)
                .build();

        try {
            return restTemplate
                    .exchange(request, UserDto.class)
                    .getBody();
        } catch (Exception e) {
            throw new GitHubException("유저 정보 획득 실패");
        }
    }
}
