package com.example.studysprings2025.service.impl;

import com.example.studysprings2025.entity.Car;
import com.example.studysprings2025.repository.CarRepository;
import com.example.studysprings2025.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {
    private CarRepository carRepository = new CarRepository();

    @Override
    public Car saveCar(Car car) {
        return carRepository.saveCar(car);
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.updateCar(car);
    }

    @Override
    public Car patchUpdateCar(Long id, Car car) {
        Car savedCar = carRepository.findById(id);

        if(car == null){
            throw new IllegalArgumentException("Car not found with id: " + id);
        }


        if (car.getModel() != null) {
            savedCar.setModel(car.getModel());
        }

        if (car.getBrand() != null) {
            savedCar.setBrand(car.getBrand());
        }

        if (car.getRegistrationNumber() != null) {
            savedCar.setRegistrationNumber(car.getRegistrationNumber());
        }

        carRepository.updateCar(savedCar);

        return savedCar;
    }


    @Override
    public Car get(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id);

        if(car == null){
            throw new IllegalArgumentException("Car not found with id: " + id);
        }

       carRepository.deleteCar(id);
    }
}
