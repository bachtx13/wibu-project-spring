package com.bachtx.exampeservice.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseStatusEnum {
    SUCCESS("success"), ERROR("error"), FAIL("fail");
    private final String status;
}
