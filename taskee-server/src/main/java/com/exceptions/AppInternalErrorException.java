package com.exceptions;

import org.springframework.http.HttpStatus;

public class AppInternalErrorException extends RuntimeException {
    //HttpStatus.INTERNAL_SERVER_ERROR
    private String message;
    private HttpStatus httpStatus;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public AppInternalErrorException(String messageString){
        super(messageString);
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        message = messageString;
    }
    public AppInternalErrorException(String messageString, HttpStatus httpStatus){
        super(messageString);
        message = messageString;
        this.httpStatus = httpStatus;
    }
}
