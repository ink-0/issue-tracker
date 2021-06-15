package com.issuetracker.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.exception.JwtException;

public class JwtUtil {
    private static final String JWT_SECRET = "jwtSecret";
    private static final String JWT_ISSUER = "jwtIssuer";
    private static final String USER_EMAIL = "email";
    private static final String USER_NAME = "name";
    private static final String USER_PROFILE_IMAGE_URL = "profileImageUrl";

    private JwtUtil() {
    }

    public static String createJwt(UserDto user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                    .withIssuer(JWT_ISSUER)
                    .withClaim(USER_EMAIL, user.getEmail())
                    .withClaim(USER_NAME, user.getName())
                    .withClaim(USER_PROFILE_IMAGE_URL, user.getProfileImageUrl())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JwtException("JWT 생성 실패");
        }
    }

    public static UserDto decodeJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(JWT_ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            String email = jwt.getClaim(USER_EMAIL).asString();
            String name = jwt.getClaim(USER_NAME).asString();
            String profileImageUrl = jwt.getClaim(USER_PROFILE_IMAGE_URL).asString();

            return new UserDto(email, name, profileImageUrl);

        } catch (JWTVerificationException exception) {
            throw new JwtException("잘못된 jwt 입니다.");
        }
    }
}
