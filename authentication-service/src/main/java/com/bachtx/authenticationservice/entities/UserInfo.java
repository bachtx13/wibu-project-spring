package com.bachtx.authenticationservice.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table("user_info")
public class UserInfo {
    @Id
    private UUID id;
    private String phone;
    
}
