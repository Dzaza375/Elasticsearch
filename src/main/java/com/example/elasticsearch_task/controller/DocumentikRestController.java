package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
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
    public ResponseEntity<?> createDocumentik(@Valid @RequestBody DocumentikDTO documentikDTO) {
        try {
            documentikService.createDocumentik(documentikDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(documentikDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error while creating a document: " + e.getMessage()));
        }
    }

    @GetMapping("/documents")
    public ResponseEntity<?> getAll(@RequestParam(required = false, defaultValue = "dateAdded") String sortBy,
                                    @RequestParam(required = false, defaultValue = "0") int page,
                                    @RequestParam(required = false, defaultValue = "10") int size) {
        try
        {
            List<DocumentikDTO> documents = documentikService.findAll(SortField.fromString(sortBy), page, size);

            if (!documents.isEmpty()) return ResponseEntity.ok(documents);
            else return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ErrorResponse("Error: " + e.getMessage()));
        }
    }
}
