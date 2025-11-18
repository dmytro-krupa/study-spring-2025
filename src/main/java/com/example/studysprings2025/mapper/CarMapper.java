package com.example.studysprings2025.mapper;

import com.example.studysprings2025.dto.CarDTO;
import com.example.studysprings2025.dto.FullPriceCarDTO;
import com.example.studysprings2025.entity.Car;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CarMapper {
    public CarDTO fromEntity(final Car car){
        CarDTO carDTO = new CarDTO();

        carDTO.setId(car.getId());
        carDTO.setBrand(car.getBrand());
        carDTO.setModel(car.getModel());
        carDTO.setRegistrationNumber(car.getRegistrationNumber());

        return carDTO;
    }

    public Car toEntity(final CarDTO carDTO){
        Car car = new Car();

        car.setId(carDTO.getId());
        car.setModel(carDTO.getModel());
        car.setBrand(carDTO.getBrand());
        car.setRegistrationNumber(carDTO.getRegistrationNumber());

        return car;
    }

    public FullPriceCarDTO toFullPriceCarDTO(Car car, BigDecimal totalPrice){
        FullPriceCarDTO fullPriceCarDTO = new FullPriceCarDTO();

        fullPriceCarDTO.setId(car.getId());
        fullPriceCarDTO.setBrand(car.getBrand());
        fullPriceCarDTO.setModel(car.getModel());
        fullPriceCarDTO.setRegistrationNumber(car.getRegistrationNumber());
        fullPriceCarDTO.setFullPrice(totalPrice);

        return fullPriceCarDTO;
    }
}
