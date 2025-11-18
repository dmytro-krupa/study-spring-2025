package com.example.studysprings2025.repository;

import com.example.studysprings2025.entity.Detail;
import com.example.studysprings2025.exception.ResourceNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

@Repository
public class DetailRepository {
    private long detailCounter = 0;
    private List<Detail> details = new LinkedList<>();

    public Detail saveDetail(Detail detail) {
        detail.setId(++detailCounter);
        details.add(detail);

        return detail;
    }

    public Detail updateDetail(Detail detail) {
        Detail saved = details.stream()
                .filter(e -> e.getId().equals(detail.getId()))
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException());

        saved.setName(detail.getName());
        saved.setPrice(detail.getPrice());

        return saved;
    }

    public Detail findById(Long id) {
        return details.stream()
                .filter(e -> e.getId().equals(id))
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException());
    }

    public List<Detail> getAllDetails() {
        return details;
    }

    public void deleteDetail(Long id) {
        this.details = details.stream()
                .filter(e -> !e.getId().equals(id))
                .toList();
    }
}
