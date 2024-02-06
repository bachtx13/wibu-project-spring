package com.bachtx.authenticationservice.dto.response;

import com.bachtx.authenticationservice.enums.ResponseStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BaseResponse<T> {
    private ResponseStatusEnum status;
    private String message;
    private T data;
}
