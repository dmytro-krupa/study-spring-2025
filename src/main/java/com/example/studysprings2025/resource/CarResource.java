package com.example.studysprings2025.resource;

import com.example.studysprings2025.dto.CarDTO;
import com.example.studysprings2025.dto.FullPriceCarDTO;
import com.example.studysprings2025.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/car")
public class CarResource {
    private final CarService carService;

    @PostMapping
    public CarDTO saveCar(@RequestBody CarDTO carDTO) {
        return carService.saveCar(carDTO);
    }

    @PutMapping
    public CarDTO updateCar(@RequestBody CarDTO carDTO) {
        return carService.updateCar(carDTO);
    }

    @PatchMapping("/{id}")
    public CarDTO patchUpdateCar(@PathVariable Long id, @RequestBody CarDTO carDTO) {
        return carService.patchUpdateCar(id, carDTO);
    }

    @GetMapping("/{id}")
    public CarDTO get(@PathVariable Long id) {
        return carService.get(id);
    }

    @GetMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }
    @PostMapping("/{carId}/detail/{detailId}")
    public void addDetail(@PathVariable Long carId, @PathVariable Long detailId) {
        carService.addDetailToCar(carId, detailId);
    }

    @GetMapping("/{id}/full-price")
    public FullPriceCarDTO addDetail(@PathVariable Long id) {
        return carService.getFullFixingPrice(id);
    }
}
