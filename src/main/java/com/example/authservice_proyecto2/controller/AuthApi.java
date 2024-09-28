package com.example.authservice_proyecto2.controller;

import com.example.authservice_proyecto2.common.contants.ApiPathConstants;
import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import com.example.authservice_proyecto2.common.dtos.userRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(ApiPathConstants.v1_route + ApiPathConstants.auth_route)
public interface AuthApi {
    @PostMapping("/register")
    ResponseEntity<TokenResponse>Createuser(@RequestBody @Valid userRequest userrequest);

    @PostMapping("/login")
    ResponseEntity<TokenResponse> loginUser(@RequestBody @Valid userRequest userrequest);



}
