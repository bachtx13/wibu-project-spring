package com.bachtx.authenticationservice.services;

import com.bachtx.authenticationservice.dto.request.LoginRequest;
import com.bachtx.authenticationservice.dto.request.RegisterRequest;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import reactor.core.publisher.Mono;

public interface IAuthService {
    Mono<UserResponse> getUserByEmail(String email);

    Mono<UserResponse> register(RegisterRequest registerRequest);

    Mono<UserResponse> login(LoginRequest loginRequest);
}
