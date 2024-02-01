package com.bachtx.exampeservice.services;

import com.bachtx.exampeservice.dto.response.ExamResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IExamService {
    Mono<ExamResponse> findById(UUID id);
}
