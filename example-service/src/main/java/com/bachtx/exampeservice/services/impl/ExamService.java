package com.bachtx.exampeservice.services.impl;

import com.bachtx.exampeservice.dto.response.ExamResponse;
import com.bachtx.exampeservice.mappers.ExamMapper;
import com.bachtx.exampeservice.repositories.ExamRepository;
import com.bachtx.exampeservice.services.IExamService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ExamService implements IExamService {
    private final ExamRepository examRepository;
    private final ExamMapper examMapper = ExamMapper.INSTANCE;

    @Override
    public Mono<ExamResponse> findById(UUID id) {
        return examRepository.findExamById(id).map(examMapper::examToExamResponse);
    }
}
