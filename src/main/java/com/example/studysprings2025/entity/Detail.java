package com.example.studysprings2025.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Detail {
    private Long id;
    private String name;
    private BigDecimal price;
}
