package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.entity.Documentik;
import com.example.elasticsearch_task.enums.SortField;
import com.example.elasticsearch_task.responses.ErrorResponse;
import com.example.elasticsearch_task.service.DocumentikService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DocumentikRestController {
    private final DocumentikService documentikService;

    @PostMapping("/documents")
    public ResponseEntity<DocumentikDTO> createDocumentik(@Valid @RequestBody DocumentikDTO documentikDTO) {
        DocumentikDTO createdDocument = documentikService.createDocumentik(documentikDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdDocument);
    }

    @GetMapping("/documents")
    public ResponseEntity<List<DocumentikDTO>> getAll(@RequestParam(required = false, defaultValue = "dateAdded") String sortBy,
                                    @RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size) {
        List<DocumentikDTO> documents = documentikService.findAll(SortField.fromString(sortBy), page, size);

        return documents.isEmpty()
                ? ResponseEntity.noContent().build()
                : ResponseEntity.ok(documents);
    }

    @DeleteMapping("/documents/{docId}")
    public ResponseEntity<Void> deleteDocumentik(@PathVariable(value = "docId") String docId) {
        documentikService.deleteDocumentik(docId);
        return ResponseEntity.noContent().build();
    }
}
