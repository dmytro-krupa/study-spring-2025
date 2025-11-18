package com.example.studysprings2025.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FullPriceCarDTO {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private BigDecimal fullPrice;
}
