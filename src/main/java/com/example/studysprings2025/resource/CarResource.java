package com.example.studysprings2025.resource;

import com.example.studysprings2025.entity.Car;
import com.example.studysprings2025.service.CarService;
import com.example.studysprings2025.service.impl.CarServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarResource {
    private CarService carService = new CarServiceImpl();

    @PostMapping
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }

    @PatchMapping("/{id}")
    public Car patchUpdateCar(@PathVariable Long id, @RequestBody Car car) {
        return carService.patchUpdateCar(id, car);
    }

    @GetMapping("/{id}")
    public Car get(@PathVariable Long id) {
        return carService.get(id);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
}

