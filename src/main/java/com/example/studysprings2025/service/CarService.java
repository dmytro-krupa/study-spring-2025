package com.example.studysprings2025.service;

import com.example.studysprings2025.dto.CarDTO;
import com.example.studysprings2025.dto.FullPriceCarDTO;
import com.example.studysprings2025.entity.Car;

import java.util.List;

public interface CarService {
    CarDTO saveCar(CarDTO car);

    CarDTO updateCar(CarDTO car);

    CarDTO patchUpdateCar(Long id, CarDTO car);

    CarDTO get(Long id);

    List<CarDTO> getAllCars();

    void deleteCar(Long id);

    void addDetailToCar(Long carId, Long detailId);

    FullPriceCarDTO getFullFixingPrice(Long carId);
}
