package com.example.userservice.security.jwt;

import com.example.userservice.dto.UserResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtServiceImpl implements JwtService {

    @Value("${token.expiration_time}")
    private long expirationTime;

    @Value("${token.secret}")
    private String secret;

    @Override
    public String buildJwtFromUserDetails(String userId, UserResponse userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUserId())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
