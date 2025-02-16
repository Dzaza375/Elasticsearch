package com.example.elasticsearch_task.controller;

import com.example.elasticsearch_task.dto.DocumentikDTO;
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
            System.out.println("Error");
            model.addAttribute("documentik", documentikDTO);
            return "create-document";
        }

        documentikService.createDocumentik(documentikDTO);
        System.out.println("Created");
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
}
