package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.service.DocumentikService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestingController {
    private final DocumentikService documentikService;

    @PostMapping("/create-document")
    public ResponseEntity<DocumentikDTO> createDoc(@RequestBody DocumentikDTO documentikDTO) {
        return ResponseEntity.ok(documentikDTO);
    }
}
