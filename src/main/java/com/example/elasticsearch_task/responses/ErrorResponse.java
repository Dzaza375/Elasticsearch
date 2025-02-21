package com.example.elasticsearch_task.responses;

import java.time.LocalDateTime;

public class ErrorResponse {
    private String error;
    private LocalDateTime timestamp;

    public ErrorResponse(String error)
    {
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
