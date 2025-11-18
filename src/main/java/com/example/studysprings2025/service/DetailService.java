package com.example.studysprings2025.service;

import com.example.studysprings2025.dto.DetailDTO;

import java.util.List;

public interface DetailService {
    DetailDTO saveDetail(DetailDTO detailDTO);

    DetailDTO updateDetail(DetailDTO detailDTO);

    DetailDTO patchUpdateDetail(Long id, DetailDTO detailDTO);

    DetailDTO get(Long id);

    List<DetailDTO> getAllDetails();

    void deleteDetail(Long id);
}
