package com.bachtx.exampeservice.repositories;

import com.bachtx.exampeservice.entities.Exam;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface ExamRepository extends R2dbcRepository<Exam, UUID> {
    Mono<Exam> findExamById(UUID id);
}
