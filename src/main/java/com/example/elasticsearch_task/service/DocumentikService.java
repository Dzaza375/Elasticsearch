package com.example.elasticsearch_task.service;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.entity.Documentik;
import com.example.elasticsearch_task.enums.SortField;
import com.example.elasticsearch_task.exceptions.DocumentiksNotFoundException;
import com.example.elasticsearch_task.mapper.DocumentikMapper;
import com.example.elasticsearch_task.repo.DocumentikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DocumentikService {
    private final DocumentikRepo documentikRepo;

    public DocumentikDTO createDocumentik(DocumentikDTO documentikDTO) {
        Documentik savedDocument = documentikRepo.save(DocumentikMapper.toEntity(documentikDTO));
        return DocumentikMapper.toDto(savedDocument);
    }

    public List<DocumentikDTO> findDocumentiksByContaining(String query) {
        return DocumentikMapper.toDtoList(documentikRepo.searchByText(query));
    }

    public List<DocumentikDTO> findAll(SortField sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, sortBy.getSort());
        return DocumentikMapper.toDtoList(documentikRepo.findAll(pageable));
    }

    public void deleteDocumentik(String id) {
        Documentik documentik = documentikRepo.findById(id)
                .orElseThrow(() -> new DocumentiksNotFoundException("Document with id " + id + " was not found"));

        documentikRepo.delete(documentik);
    }
}
