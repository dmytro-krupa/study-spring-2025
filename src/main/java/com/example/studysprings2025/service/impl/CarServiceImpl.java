package com.example.studysprings2025.service.impl;

import com.example.studysprings2025.dto.CarDTO;
import com.example.studysprings2025.dto.FullPriceCarDTO;
import com.example.studysprings2025.entity.Car;
import com.example.studysprings2025.entity.Detail;
import com.example.studysprings2025.mapper.CarMapper;
import com.example.studysprings2025.repository.CarRepository;
import com.example.studysprings2025.repository.DetailRepository;
import com.example.studysprings2025.service.CarService;
import com.example.studysprings2025.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;
    private final DetailRepository detailRepository;

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        return carMapper.fromEntity(carRepository.saveCar(car));
    }

    @Override
    public CarDTO updateCar(CarDTO carDTO) {
        Car car = carMapper.toEntity(carDTO);
        return carMapper.fromEntity(carRepository.updateCar(car));
    }

    @Override
    public CarDTO patchUpdateCar(Long id, CarDTO carDTO) {
        Car savedCar = carRepository.findById(id);

        if (carDTO == null) {
            throw new IllegalArgumentException("Car not found with id: " + id);
        }


        if (carDTO.getModel() != null) {
            savedCar.setModel(carDTO.getModel());
        }

        if (carDTO.getBrand() != null) {
            savedCar.setBrand(carDTO.getBrand());
        }

        if (carDTO.getRegistrationNumber() != null) {
            savedCar.setRegistrationNumber(carDTO.getRegistrationNumber());
        }

        carRepository.updateCar(savedCar);

        return carMapper.fromEntity(savedCar);
    }


    @Override
    public CarDTO get(Long id) {
        return carMapper.fromEntity(carRepository.findById(id));
    }

    @Override
    public List<CarDTO> getAllCars() {
        return carRepository.getAllCars()
                .stream()
                .map(carMapper::fromEntity)
                .toList();
    }

    @Override
    public void deleteCar(Long id) {
        Car car = carRepository.findById(id);

        if (car == null) {
            throw new IllegalArgumentException("Car not found with id: " + id);
        }

        carRepository.deleteCar(id);
    }

    @Override
    public void addDetailToCar(Long carId, Long detailId) {
        var car = carRepository.findById(carId);
        var detail = detailRepository.findById(detailId);

        car.getDetails().add(detail);
    }

    @Override
    public FullPriceCarDTO getFullFixingPrice(Long carId) {
        var car = carRepository.findById(carId);

        var totalPrice = calculateTotalPrice(car.getDetails());

        return carMapper.toFullPriceCarDTO(car, totalPrice);
    }

    private BigDecimal calculateTotalPrice(Collection<Detail> details){
        return details
                .stream()
                .map(Detail::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
