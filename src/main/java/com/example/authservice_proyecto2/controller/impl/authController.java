package com.example.authservice_proyecto2.controller.impl;

import com.example.authservice_proyecto2.Service.AuthService;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import com.example.authservice_proyecto2.common.dtos.userRequest;
import com.example.authservice_proyecto2.controller.AuthApi;
import org.springframework.http.ResponseEntity;

public class authController implements AuthApi {
    private final AuthService authService;

    public authController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<TokenResponse> Createuser(userRequest userrequest) {
        return ResponseEntity.ok(authService.createUser(userrequest.getEmail(), userrequest.getPassword()));
    }
}
