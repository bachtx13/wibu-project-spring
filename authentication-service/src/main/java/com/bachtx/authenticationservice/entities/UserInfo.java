package com.bachtx.authenticationservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table
@Getter
@Setter
@AllArgsConstructor
public class UserInfo {
    @Id
    private UUID id;
    private String fullName;
    private String phone;
    private String gender;
    private String avatar;
}
