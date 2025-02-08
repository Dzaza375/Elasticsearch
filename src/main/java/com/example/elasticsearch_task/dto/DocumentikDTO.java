package com.example.elasticsearch_task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class DocumentikDTO {
    @NotNull(message = "Id cannot be empty")
    private String id;

    @NotBlank(message = "Text cannot be empty")
    @Size(min = 5, max = 500, message = "Text is too big or too small")
    private String text;

    @NotNull(message = "Data cannot be empty")
    @PastOrPresent(message = "Data cannot be from the future")
    @JsonFormat(pattern = "dd.MM.yyyy")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate dateAdded;
}
