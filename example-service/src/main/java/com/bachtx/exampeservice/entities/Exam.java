package com.bachtx.exampeservice.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@Table
public class Exam {
    @Id
    private UUID id;
    private String name;
    //...some properties
}
