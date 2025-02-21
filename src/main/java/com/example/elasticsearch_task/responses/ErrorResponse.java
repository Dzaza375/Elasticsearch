package com.example.elasticsearch_task.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ErrorResponse {
    private String error;
    private LocalDateTime timestamp;

    public ErrorResponse(String error)
    {
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }
}
