package com.bachtx.exampeservice.enums;

import lombok.Getter;

@Getter
public enum ResponseStatusEnum {
    SUCCESS("success"), ERROR("error");
    private final String status;

    ResponseStatusEnum(String status) {
        this.status = status;
    }
}
