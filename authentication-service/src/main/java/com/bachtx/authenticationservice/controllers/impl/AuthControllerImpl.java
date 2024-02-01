package com.bachtx.authenticationservice.controllers.impl;

import com.bachtx.authenticationservice.controllers.AuthController;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin
@RestController
@RequestMapping(value = "/")
public class AuthControllerImpl implements AuthController {

    @Override
    public Mono<String> helloWorld() {
        return Mono.just("Hello world");
    }

    @Override
    public Mono<UserResponse> register() {
        return null;
    }
}
