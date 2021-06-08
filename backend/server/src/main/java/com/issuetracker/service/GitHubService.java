package com.issuetracker.service;

import com.issuetracker.dto.auth.AccessTokenRequest;
import com.issuetracker.dto.auth.AccessTokenResponse;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.exception.GitHubException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubService {
    private static final String GITHUB_ACCESS_TOKEN_URI = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_USER_URI = "https://api.github.com/user";
    private static RestTemplate restTemplate = new RestTemplate();

    @Value("${github.client.id}")
    private String CLIENT_ID;

    @Value("${github.client.secret}")
    private String CLIENT_SECRET;

    public AccessTokenResponse getAccessToken(String code) {
        RequestEntity<AccessTokenRequest> request = RequestEntity
                .post(GITHUB_ACCESS_TOKEN_URI)
                .header("Accept", "application/json")
                .body(new AccessTokenRequest(CLIENT_ID, CLIENT_SECRET, code));

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
