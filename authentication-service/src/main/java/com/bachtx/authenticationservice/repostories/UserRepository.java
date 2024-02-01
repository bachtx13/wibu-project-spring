package com.bachtx.authenticationservice.repostories;

import com.bachtx.authenticationservice.entities.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface UserRepository extends R2dbcRepository<User, UUID> {
    Mono<User> findUserByEmail(String email);
}
