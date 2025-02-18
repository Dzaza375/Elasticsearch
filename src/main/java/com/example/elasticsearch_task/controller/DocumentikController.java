package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
import com.example.elasticsearch_task.enums.SortField;
import com.example.elasticsearch_task.service.DocumentikService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/documents")
public class DocumentikController {
    private final DocumentikService documentikService;

    @GetMapping("/create")
    public String createDocumentPage(@ModelAttribute DocumentikDTO documentikDTO) {
        return "create-document";
    }

    @PostMapping("/create")
    public String createNewDocument(@Valid @ModelAttribute DocumentikDTO documentikDTO,
                                    BindingResult bindingResult,
                                    Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("documentik", documentikDTO);
            return "create-document";
        }

        documentikService.createDocumentik(documentikDTO);
        return "redirect:/documents/create";
    }

    @GetMapping("/find")
    public String findDocumentPage() {
        return "find-documents-form";
    }

    @GetMapping("/find/results")
    public String findDocument(@RequestParam String query, Model model) {
        List<DocumentikDTO> documents = null;

        if(query != null && !query.isEmpty()) documents = documentikService.findDocumentiksByContaining(query);

        model.addAttribute("documents", documents);
        return "find-results";
    }

    @GetMapping("/all")
    public String findAll(@RequestParam(required = false, defaultValue = "dateAdded") String sortBy,
                          @RequestParam(required = false, defaultValue = "0") int page,
                          @RequestParam(required = false, defaultValue = "10") int size,
                          Model model) {
        List<DocumentikDTO> documents = null;

        if (sortBy.equals("dateAdded") || sortBy.equals("text")) documents = documentikService.findAll(SortField.fromString(sortBy), page, size);

        model.addAttribute("documents", documents);
        return "all-documents";
    }
}
