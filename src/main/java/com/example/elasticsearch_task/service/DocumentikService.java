package com.example.elasticsearch_task.service;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.mapper.DocumentikMapper;
import com.example.elasticsearch_task.repo.DocumentikRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class DocumentikService {
    private final DocumentikRepo documentikRepo;

    public void createDocumentik(DocumentikDTO documentikDTO) {
        documentikRepo.save(DocumentikMapper.toEntity(documentikDTO));
    }

    public List<DocumentikDTO> findDocumentiksByContaining(String query) {
        return DocumentikMapper.toDtoList(documentikRepo.searchByText(query));
    }

    public List<DocumentikDTO> findAll(String sortBy, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return DocumentikMapper.toDtoList(documentikRepo.findAll(pageable));
    }
}
