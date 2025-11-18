package com.example.studysprings2025.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetailDTO {
    private Long id;
    private String name;
    private BigDecimal price;
}

