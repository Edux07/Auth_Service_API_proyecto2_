package com.example.authservice_proyecto2.Service.impl;

import com.example.authservice_proyecto2.Repository.UserRepository;
import com.example.authservice_proyecto2.Service.AuthService;
import com.example.authservice_proyecto2.Service.jwtService;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import com.example.authservice_proyecto2.common.dtos.userRequest;
import com.example.authservice_proyecto2.common.entities.userModel;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class authServiceImplementation implements AuthService {
    private final UserRepository userRepository;
    private final jwtService jwtservice;

    public authServiceImplementation(UserRepository userRepository, jwtService jwtservice) {
        this.userRepository = userRepository;
        this.jwtservice = jwtservice;


    }
    @Override
    public TokenResponse createUser(userRequest userrequest) {
        return Optional.of(userrequest).map(this::maptoEntity).map(userRepository::save).
                map(userCreated -> jwtservice.generateToken(userCreated.getId()))
                .orElseThrow(() -> new RuntimeException("Error creating user"));
    }

    @Override
    public TokenResponse loginUser(userRequest userrequest) {
        userModel user = userRepository.findByEmail(userrequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if (user.getPassword().equals(userrequest.getPassword())) {
            return jwtservice.generateToken(user.getId());
        }else {
            throw new BadCredentialsException("Invalid credentials");
        }

    }


    private userModel maptoEntity(userRequest userrequest) {
        return userModel.builder()
                .email(userrequest.getEmail())
                .password(userrequest.getPassword())
                .role("USER")
                .build();
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
