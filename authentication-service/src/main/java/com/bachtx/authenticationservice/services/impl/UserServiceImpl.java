package com.bachtx.authenticationservice.services.impl;

import com.bachtx.authenticationservice.dto.request.LoginRequest;
import com.bachtx.authenticationservice.dto.request.RegisterRequest;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import com.bachtx.authenticationservice.mappers.UserMapper;
import com.bachtx.authenticationservice.repostories.UserRepository;
import com.bachtx.authenticationservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public Mono<UserResponse> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).map(userMapper::userToUserResponse);
    }

    @Override
    public Mono<UserResponse> register(RegisterRequest registerRequest) {
        return null;
    }

    @Override
    public Mono<UserResponse> login(LoginRequest loginRequest) {
        return null;
    }
}
