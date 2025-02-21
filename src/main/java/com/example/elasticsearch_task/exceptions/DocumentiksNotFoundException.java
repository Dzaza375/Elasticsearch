package com.example.elasticsearch_task.exceptions;

public class DocumentiksNotFoundException extends RuntimeException {
    public DocumentiksNotFoundException(String message) {
        super(message);
    }
}
