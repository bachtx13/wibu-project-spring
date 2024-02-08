package com.bachtx.authenticationservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.UUID;

@Table(value = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    private UUID id;
    private String email;
    private String password;
    @Transient
    private List<Role> roles;
}
