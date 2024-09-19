package com.example.authservice_proyecto2.Service.impl;

import com.example.authservice_proyecto2.Service.jwtService;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class jwtServiceImpl implements jwtService {

    private final String secretToken;

    public jwtServiceImpl(@Value("${jwt.secret}") String secretToken) {
        this.secretToken = secretToken;
    }

    @Override
    public TokenResponse generateToken(Long userID) {
        Date expiration = new Date(Long.MAX_VALUE);
        String token = Jwts.builder().setSubject(String.valueOf(userID))
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS512, secretToken)
                .compact();
        return TokenResponse.builder().accesstoken(token).build();
    }

    @Override
    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(this.secretToken)
                .build().parseClaimsJwt(token)
                .getBody();
    }

    @Override
    public boolean isExpired(String token) {
        try {
           return getClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Integer extractUserId(String token) {
       try {
           return Integer.parseInt(getClaims(token).getSubject());
       } catch (Exception e) {
           return null;
       }
    }
}