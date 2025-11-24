package com.murat.backend.exception.message;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Oluşan exceptionları throw ettiğimiz zaman cliente gönderilecek bir error sınıfı. Aslında bir DTO sınıfı gibi
 */
public class ApiResponseError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String requestURI;

    private ApiResponseError() {
        timestamp = LocalDateTime.now();
    }

    public ApiResponseError(HttpStatus status) {
        this();
        this.status = status;
    }

    public ApiResponseError(HttpStatus status, String message, String requestURI) {
        this(status);
        this.message = message;
        this.requestURI = requestURI;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestURI() {
        return requestURI;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }
}

