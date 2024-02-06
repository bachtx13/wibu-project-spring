package com.bachtx.authenticationservice.controllers.advice;

import com.bachtx.authenticationservice.dto.response.BaseResponse;
import com.bachtx.authenticationservice.dto.response.ErrorResponse;
import com.bachtx.authenticationservice.enums.ResponseStatusEnum;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({WebExchangeBindException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Mono<BaseResponse<ErrorResponse>> validationExceptionHandler(WebExchangeBindException ex) {
        BaseResponse<ErrorResponse> errorResponse = new BaseResponse<>();
        errorResponse.setStatus(ResponseStatusEnum.ERROR);
        errorResponse.setMessage("Validation failed");
        errorResponse.setData(
                ErrorResponse.builder()
                        .message(ex.getReason())
                        .details(ex.getAllErrors().stream().map(
                                DefaultMessageSourceResolvable::getDefaultMessage
                        ).toList())
                        .build()
        );
        return Mono.just(errorResponse);
    }

}
