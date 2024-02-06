package com.bachtx.authenticationservice.exceptions;

public class UserAlreadyExisted extends RuntimeException {
    public UserAlreadyExisted() {
    }

    public UserAlreadyExisted(String message) {
        super(message);
    }

    public UserAlreadyExisted(String message, Throwable cause) {
        super(message, cause);
    }

    public UserAlreadyExisted(Throwable cause) {
        super(cause);
    }

    public UserAlreadyExisted(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
