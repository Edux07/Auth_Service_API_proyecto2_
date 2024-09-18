package com.example.authservice_proyecto2.Service;

import com.example.authservice_proyecto2.common.dtos.TokenResponse;

public interface AuthService {
    TokenResponse createUser(String email, String password);
}
