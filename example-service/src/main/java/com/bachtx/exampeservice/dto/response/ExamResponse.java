package com.bachtx.exampeservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class ExamResponse {
    private UUID id;
    private String name;
}
