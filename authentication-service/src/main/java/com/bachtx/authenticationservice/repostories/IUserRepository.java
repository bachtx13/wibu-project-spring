package com.bachtx.authenticationservice.repostories;

import com.bachtx.authenticationservice.entities.User;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface IUserRepository extends R2dbcRepository<User, UUID> {
    Mono<User> findUserByEmail(String email);

    Mono<Boolean> existsByEmail(String email);
}
