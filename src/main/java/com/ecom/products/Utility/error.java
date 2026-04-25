package com.ecom.products.Utility;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class error {
    private LocalDateTime timestamp;
    private String error;
    private HttpStatus statusCode;
    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public HttpStatus getStatusCode() {
        return statusCode;
    }
    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }
    
    @Override
    public String toString() {
        return "error [timestamp=" + timestamp + ", error=" + error + ", statusCode=" + statusCode + "]";
    }

    public error() {
		this.timestamp = LocalDateTime.now();
	}
    
    public error(String error, HttpStatus statusCode) {
        this();
        this.error = error;
        this.statusCode = statusCode;
    }

    
}
