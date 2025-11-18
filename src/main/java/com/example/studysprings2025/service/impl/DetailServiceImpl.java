package com.example.studysprings2025.service.impl;

import com.example.studysprings2025.dto.DetailDTO;
import com.example.studysprings2025.entity.Detail;
import com.example.studysprings2025.mapper.DetailMapper;
import com.example.studysprings2025.repository.DetailRepository;
import com.example.studysprings2025.service.DetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailRepository detailRepository;

    private final DetailMapper detailMapper;

    @Override
    public DetailDTO saveDetail(DetailDTO detailDTO) {
        Detail detail = detailMapper.toEntity(detailDTO);
        return detailMapper.fromEntity(detailRepository.saveDetail(detail));
    }

    @Override
    public DetailDTO updateDetail(DetailDTO detailDTO) {
        Detail detail = detailMapper.toEntity(detailDTO);
        return detailMapper.fromEntity(detailRepository.updateDetail(detail));
    }

    @Override
    public DetailDTO patchUpdateDetail(Long id, DetailDTO detailDTO) {
        Detail saved = detailRepository.findById(id);

        if (detailDTO == null) {
            throw new IllegalArgumentException("Detail not found with id: " + id);
        }

        if (detailDTO.getName() != null) {
            saved.setName(detailDTO.getName());
        }

        if (detailDTO.getPrice() != null) {
            saved.setPrice(detailDTO.getPrice());
        }

        detailRepository.updateDetail(saved);

        return detailMapper.fromEntity(saved);
    }

    @Override
    public DetailDTO get(Long id) {
        return detailMapper.fromEntity(detailRepository.findById(id));
    }

    @Override
    public List<DetailDTO> getAllDetails() {
        return detailRepository.getAllDetails()
                .stream()
                .map(detailMapper::fromEntity)
                .toList();
    }

    @Override
    public void deleteDetail(Long id) {
        Detail detail = detailRepository.findById(id);

        if (detail == null) {
            throw new IllegalArgumentException("Detail not found with id: " + id);
        }

        detailRepository.deleteDetail(id);
    }
}
