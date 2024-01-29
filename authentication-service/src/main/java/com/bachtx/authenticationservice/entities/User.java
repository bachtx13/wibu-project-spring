package com.bachtx.authenticationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    private UUID id;
    private String email;
    private String password;
    private List<Role> roles;
}
