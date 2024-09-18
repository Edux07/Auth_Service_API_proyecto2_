package com.example.authservice_proyecto2.Service.impl;

import com.example.authservice_proyecto2.Service.jwtService;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import io.jsonwebtoken.Claims;
import lombok.Value;

public class jwtImplementation implements jwtService {

    private final String SECRETTOKEN;

    public jwtImplementation(@Value("${jwt.secret}") String secrettoken) {
        this.SECRETTOKEN = secrettoken;
    }

    @Override
    public TokenResponse generateToken(Long userID) {
        return null;
    }

    @Override
    public Claims getClaims(String token) {
        return null;
    }

    @Override
    public boolean isExpired(String token) {
        return false;
    }

    @Override
    public Integer extractUserId(String token) {
        return null;
    }
}
