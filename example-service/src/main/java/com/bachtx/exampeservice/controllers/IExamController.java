package com.bachtx.exampeservice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

public interface IExamController {
    @RequestMapping("/hello-world")
    Mono<String> helloWorld();
}
