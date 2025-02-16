package com.example.elasticsearch_task.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Data
@Document(indexName = "documentiks")
public class Documentik {
    @Id
    @NotNull
    private String id;

    @Field(type = FieldType.Text)
    @NotNull
    private String text;

    @Field(type = FieldType.Date, format = DateFormat.date, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateAdded;
}
