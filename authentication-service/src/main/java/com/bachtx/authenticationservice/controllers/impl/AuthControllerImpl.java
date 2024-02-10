package com.bachtx.authenticationservice.controllers.impl;

import com.bachtx.authenticationservice.controllers.IAuthController;
import com.bachtx.authenticationservice.dto.request.RegisterRequest;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import com.bachtx.authenticationservice.services.IAuthService;
import com.bachtx.authenticationservice.utils.TokenUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@CrossOrigin
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class AuthControllerImpl implements IAuthController {
    private final IAuthService authService;
    private final TokenUtil tokenUtil;
    Logger logger = LoggerFactory.getLogger(IAuthController.class);

    @Override
    public Mono<String> helloWorld() {
        return Mono.just(tokenUtil.getKey().toString());
    }

    @Override
    public Mono<UserResponse> register(RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Override
    public Mono<UserResponse> getUser(String email) {
        return authService.getUserByEmail(email);
    }
}
