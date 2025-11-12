package com.example.studysprings2025.repository;

import com.example.studysprings2025.entity.Car;
import com.example.studysprings2025.exception.ResourceNotFoundException;

import java.util.LinkedList;
import java.util.List;

public class CarRepository {
    private long carCounter = 0;
    private List<Car> cars = new LinkedList<>();

    public Car saveCar(Car car) {
        car.setId(++carCounter);
        cars.add(car);

        return car;
    }

    public Car updateCar(Car car) {
        Car savedCar = cars.stream()
                .filter(e -> e.getId().equals(car.getId()))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());

        savedCar.setModel(car.getModel());
        savedCar.setBrand(car.getBrand());
        savedCar.setRegistrationNumber(car.getRegistrationNumber());

        return savedCar;
    }


    public Car findById(Long id) {
        return cars.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public void deleteCar(Long id) {
        this.cars = cars.stream()
                .filter(e -> !e.getId().equals(id))
                .toList();
    }
}
