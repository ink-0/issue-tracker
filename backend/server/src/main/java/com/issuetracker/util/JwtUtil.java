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
    private static final String USER_ID = "userId";

    private JwtUtil() {
    }

    public static String createJwt(UserDto user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            return JWT.create()
                    .withIssuer(JWT_ISSUER)
                    .withClaim(USER_ID, user.getEmail())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new JwtException("JWT 생성 실패");
        }
    }

    public static String decodeJwt(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(JWT_ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            String userId = jwt.getClaim(USER_ID).asString();

            return userId;

        } catch (JWTVerificationException exception) {
            throw new JwtException("잘못된 jwt 입니다.");
        }
    }
}
