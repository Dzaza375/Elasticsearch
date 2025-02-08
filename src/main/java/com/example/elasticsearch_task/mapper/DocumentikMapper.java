package com.example.elasticsearch_task.mapper;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.entity.Documentik;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DocumentikMapper {
    public static DocumentikDTO toDto(Documentik entity) {
        DocumentikDTO dto = new DocumentikDTO();
        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setDateAdded(entity.getDateAdded());
        return dto;
    }

    public static List<DocumentikDTO> toDtoList(List<Documentik> entityList) {
        return entityList.stream()
                .map(DocumentikMapper::toDto)
                .collect(Collectors.toList());
    }

    public static Documentik toEntity(DocumentikDTO dto) {
        Documentik entity = new Documentik();
        entity.setId(dto.getId());
        entity.setText(dto.getText());
        entity.setDateAdded(dto.getDateAdded());
        return entity;
    }

    public static List<Documentik> toEntityList(List<DocumentikDTO> dtoList) {
        return dtoList.stream()
                .map(DocumentikMapper::toEntity)
                .collect(Collectors.toList());
    }
}
