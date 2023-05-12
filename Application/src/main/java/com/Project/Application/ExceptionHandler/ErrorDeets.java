package com.Project.Application.ExceptionHandler;

public class ErrorDeets {
    private String message;
    private String details;

    public String getMessage() {
        return message;
    }

    public ErrorDeets() {
    }

    public ErrorDeets(String message, String details) {
        this.message = message;
        this.details = details;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
