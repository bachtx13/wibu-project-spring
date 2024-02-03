package com.bachtx.authenticationservice.constants;

public interface RegexConstants {
    String VALID_PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";
}
