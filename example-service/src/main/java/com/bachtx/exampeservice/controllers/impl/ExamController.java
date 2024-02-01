package com.bachtx.exampeservice.controllers.impl;

import com.bachtx.exampeservice.controllers.IExamController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/")
public class ExamController implements IExamController {
    @Override
    @ResponseStatus(HttpStatus.OK)
    public Mono<String> helloWorld() {
        return Mono.just("Hellooooo");
    }
}
