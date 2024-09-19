package com.example.authservice_proyecto2.Service.impl;

import com.example.authservice_proyecto2.Repository.UserRepository;
import com.example.authservice_proyecto2.Service.AuthService;
import com.example.authservice_proyecto2.Service.jwtService;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import org.springframework.stereotype.Service;

@Service

public class authServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final jwtService jwtservice;

    public authServiceImplementation(UserRepository userRepository, jwtService jwtservice) {
        this.userRepository = userRepository;
        this.jwtservice = jwtservice;


    }

    @Override
    public TokenResponse createUser(String email, String password) {
        return null;
    }
}
