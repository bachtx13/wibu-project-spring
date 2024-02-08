package com.bachtx.authenticationservice.controllers;

import com.bachtx.authenticationservice.dto.request.RegisterRequest;
import com.bachtx.authenticationservice.dto.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface IAuthController {
    @RequestMapping(value = "/hello-world")
    Mono<String> helloWorld();

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    Mono<UserResponse> register(@Valid @RequestBody RegisterRequest registerRequest);

    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    Mono<UserResponse> getUser(@RequestParam String email);
}
