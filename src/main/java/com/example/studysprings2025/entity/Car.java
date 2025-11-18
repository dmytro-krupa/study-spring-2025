package com.example.studysprings2025.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
public class Car {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;

    private List<Detail> details = new ArrayList<>();
}
