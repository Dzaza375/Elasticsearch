package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.service.DocumentikService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class DocumentikRestController {
    private final DocumentikService documentikService;

    @PostMapping("/documents")
    public ResponseEntity<?> createDocumentik(@Valid @RequestBody DocumentikDTO documentikDTO) {
        try {
            documentikService.createDocumentik(documentikDTO);
            return ResponseEntity.ok(documentikDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Ошибка при создании документа: " + e.getMessage());
        }
    }
}
