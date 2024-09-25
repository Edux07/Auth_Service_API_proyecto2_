package com.example.authservice_proyecto2.Service;

import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import com.example.authservice_proyecto2.common.dtos.userRequest;
import io.jsonwebtoken.Claims;

public interface AuthService {
    TokenResponse createUser(userRequest userrequest);

    TokenResponse generateToken(Long userID);

    //Claims es una interfaz de la libreria de JWT
    Claims getClaims(String token);
    boolean isExpired(String token);
    Integer extractUserId(String token);




}
