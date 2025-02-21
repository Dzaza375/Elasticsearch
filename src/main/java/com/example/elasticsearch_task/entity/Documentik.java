package com.example.elasticsearch_task.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;

@Data
@Document(indexName = "documentiks_index")
public class Documentik {
    @Id
    private String id;

    @MultiField(mainField = @Field(type = FieldType.Text),
                otherFields = { @InnerField(suffix = "keyword", type = FieldType.Keyword) })
    @NotNull
    private String text;

    @Field(type = FieldType.Date, format = DateFormat.date, pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate dateAdded;
}
