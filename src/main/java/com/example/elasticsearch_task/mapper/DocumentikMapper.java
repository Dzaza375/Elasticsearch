package com.example.elasticsearch_task.mapper;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.entity.Documentik;
import org.springframework.stereotype.Component;

@Component
public class DocumentikMapper {
    public static DocumentikDTO toDto(Documentik entity) {
        DocumentikDTO dto = new DocumentikDTO();
        dto.setId(entity.getId());
        dto.setText(entity.getText());
        dto.setDateAdded(entity.getDateAdded());
        return dto;
    }

    public static Documentik toEntity(DocumentikDTO dto) {
        Documentik entity = new Documentik();
        entity.setId(dto.getId());
        entity.setText(dto.getText());
        entity.setDateAdded(dto.getDateAdded());
        return entity;
    }
}
