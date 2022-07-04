package com.himanshu.Rest.APIs.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

    // what data i want to send back that i need to define here
    private HttpStatus status;
    private String message;

    public ErrorMessage() {
    }

    public ErrorMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }


    @Override
    public String toString() {
        return "ErrorMessage{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
