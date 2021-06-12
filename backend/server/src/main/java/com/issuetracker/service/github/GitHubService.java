package com.issuetracker.service.github;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.issuetracker.dto.auth.AccessTokenRequest;
import com.issuetracker.dto.auth.AccessTokenResponse;
import com.issuetracker.dto.auth.UserEmailDto;
import com.issuetracker.dto.auth.UserInfoDto;
import com.issuetracker.exception.GitHubException;
import io.netty.resolver.DefaultAddressResolverGroup;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

import java.util.Arrays;
import java.util.stream.Collectors;

public abstract class GitHubService {
    private static final String GITHUB_ACCESS_TOKEN_URI = "https://github.com/login/oauth/access_token";
    private static final String GITHUB_USER_URI = "https://api.github.com/user";
    private static final String GITHUB_EMAIL_URI = "https://api.github.com/user/emails";
    private static RestTemplate restTemplate = new RestTemplate();
    private final HttpClient httpClient = HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    private final WebClient webClient = WebClient.builder().clientConnector(new ReactorClientHttpConnector(httpClient)).build();
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

    public UserInfoDto getUser(String accessToken) {
        RequestEntity<Void> request = RequestEntity
                .get(GITHUB_USER_URI)
                .header("Accept", "application/json")
                .header("Authorization", "token " + accessToken)
                .build();

        try {
            return restTemplate
                    .exchange(request, UserInfoDto.class)
                    .getBody();
        } catch (Exception e) {
            throw new GitHubException("유저 정보 획득 실패");
        }
    }

    public UserEmailDto getEmail(String accessToken) {

        Mono<UserEmailDto[]> response = webClient.get()
                .uri(GITHUB_EMAIL_URI)
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "token " + accessToken)
                .retrieve()
                .bodyToMono(UserEmailDto[].class).log();

        Object[] objects = response.block();
        ObjectMapper mapper = new ObjectMapper();

        return Arrays.stream(objects)
                .map(object -> mapper.convertValue(object, UserEmailDto.class))
                .collect(Collectors.toList()).get(0);

    }
}
