package com.example.studysprings2025.service;

import com.example.studysprings2025.entity.Car;

import java.util.List;

public interface CarService {
    Car saveCar(Car car);

    Car updateCar(Car car);

    Car patchUpdateCar(Long id, Car car);

    Car get(Long id);

    List<Car> getAllCars();

    void deleteCar(Long id);
}
