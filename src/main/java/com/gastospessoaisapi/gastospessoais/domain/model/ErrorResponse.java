package com.gastospessoaisapi.gastospessoais.domain.model;

public class ErrorResponse {
    private String dateHour;
    private String status;
    private String title;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(String dateHour, String status, String title, String message) {
        this.dateHour = dateHour;
        this.status = status;
        this.title = title;
        this.message = message;
    }

    public String getDateHour() {
        return dateHour;
    }

    public void setDateHour(String dateHour) {
        this.dateHour = dateHour;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
