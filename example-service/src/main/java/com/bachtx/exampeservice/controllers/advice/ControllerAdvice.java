package com.bachtx.exampeservice.controllers.advice;

import com.bachtx.exampeservice.dto.response.BaseResponse;
import com.bachtx.exampeservice.exception.ResourceNotFoundException;
import com.bachtx.exampeservice.exception.UpdateResourceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler({ResourceNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Mono<BaseResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        return null;
    }

    @ExceptionHandler({UpdateResourceException.class})
    public Mono<BaseResponse> updateResourceExceptionHandler(UpdateResourceException ex) {
        return null;
    }
}
