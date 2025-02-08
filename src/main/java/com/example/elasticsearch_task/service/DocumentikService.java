package com.example.elasticsearch_task.service;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.mapper.DocumentikMapper;
import com.example.elasticsearch_task.repo.DocumentikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DocumentikService {
    private final DocumentikRepo documentikRepo;

    public void createDocumentik(DocumentikDTO documentikDTO) {
        documentikRepo.save(DocumentikMapper.toEntity(documentikDTO));
    }
}
