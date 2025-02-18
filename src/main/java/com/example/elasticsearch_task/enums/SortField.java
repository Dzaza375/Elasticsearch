package com.example.elasticsearch_task.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

@RequiredArgsConstructor
public enum SortField {
    DATE_ADDED("dateAdded", Sort.by("dateAdded")),
    TEXT("text", Sort.by("text"));

    private final String fieldName;

    @Getter
    private final Sort sort;

    public static SortField fromString(String value) {
        return Arrays.stream(values())
                .filter(e -> e.fieldName.equalsIgnoreCase(value))
                .findFirst()
                .orElse(DATE_ADDED);
    }
}
