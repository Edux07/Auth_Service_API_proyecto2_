package com.example.authservice_proyecto2.Service;

import com.example.authservice_proyecto2.common.dtos.TokenResponse;
import com.example.authservice_proyecto2.common.dtos.userRequest;

public interface AuthService {
    TokenResponse createUser(userRequest userrequest);


}
