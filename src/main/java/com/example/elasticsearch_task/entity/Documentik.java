package com.example.elasticsearch_task.entity;

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
    private String id;

    @Field(type = FieldType.Text)
    private String text;

    @Field(type = FieldType.Date, format = DateFormat.date, pattern = "dd.MM.yyyy")
    private LocalDate dateAdded;
}
