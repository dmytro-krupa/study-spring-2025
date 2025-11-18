package com.example.studysprings2025.mapper;

import com.example.studysprings2025.dto.DetailDTO;
import com.example.studysprings2025.entity.Detail;
import org.springframework.stereotype.Component;

@Component
public class DetailMapper {
    public DetailDTO fromEntity(final Detail detail){
        DetailDTO dto = new DetailDTO();

        dto.setId(detail.getId());
        dto.setName(detail.getName());
        dto.setPrice(detail.getPrice());

        return dto;
    }

    public Detail toEntity(final DetailDTO dto){
        Detail detail = new Detail();

        detail.setId(dto.getId());
        detail.setName(dto.getName());
        detail.setPrice(dto.getPrice());

        return detail;
    }
}
