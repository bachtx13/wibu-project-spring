package com.bachtx.authenticationservice.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RegisterRequest {
    private String email;
}
