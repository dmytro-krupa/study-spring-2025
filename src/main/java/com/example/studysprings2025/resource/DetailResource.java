package com.example.studysprings2025.resource;

import com.example.studysprings2025.dto.DetailDTO;
import com.example.studysprings2025.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/detail")
public class DetailResource {
    private final DetailService detailService;

    @PostMapping
    public DetailDTO saveDetail(@RequestBody DetailDTO detailDTO) {
        return detailService.saveDetail(detailDTO);
    }

    @PutMapping
    public DetailDTO updateDetail(@RequestBody DetailDTO detailDTO) {
        return detailService.updateDetail(detailDTO);
    }

    @PatchMapping("/{id}")
    public DetailDTO patchUpdateDetail(@PathVariable Long id, @RequestBody DetailDTO detailDTO) {
        return detailService.patchUpdateDetail(id, detailDTO);
    }

    @GetMapping("/{id}")
    public DetailDTO get(@PathVariable Long id) {
        return detailService.get(id);
    }

    @GetMapping
    public List<DetailDTO> getAllDetails() {
        return detailService.getAllDetails();
    }

    @DeleteMapping("/{id}")
    public void deleteDetail(@PathVariable Long id) {
        detailService.deleteDetail(id);
    }
}
