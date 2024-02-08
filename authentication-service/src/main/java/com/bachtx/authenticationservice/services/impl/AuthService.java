package com.bachtx.authenticationservice.services.impl;

import com.bachtx.authenticationservice.dto.request.LoginRequest;
import com.bachtx.authenticationservice.dto.request.RegisterRequest;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import com.bachtx.authenticationservice.entities.User;
import com.bachtx.authenticationservice.exceptions.UserAlreadyExistedException;
import com.bachtx.authenticationservice.mappers.UserMapper;
import com.bachtx.authenticationservice.repostories.IUserRepository;
import com.bachtx.authenticationservice.services.IAuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Override
    public Mono<UserResponse> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email).map(userMapper::userToUserResponse);
    }

    @Override
    public Mono<UserResponse> register(RegisterRequest registerRequest) {
        return userRepository.existsByEmail(registerRequest.getEmail())
                .flatMap(isUserExisted -> {
                    if (isUserExisted) {
                        return Mono.error(new UserAlreadyExistedException("User already exists"));
                    }
                    User user = new User();
                    user.setEmail(registerRequest.getEmail());
                    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
                    return userRepository.save(user);
                }).map(userMapper::userToUserResponse);
    }

    @Override
    public Mono<UserResponse> login(LoginRequest loginRequest) {
        return null;
    }
}
