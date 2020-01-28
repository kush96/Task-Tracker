package com.exceptions;

import com.dto.response.ResponseMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AppInternalErrorException.class)
    public ResponseEntity<Object> handleInternalException(AppInternalErrorException e, WebRequest request){
        String errorMessage = e.getMessage();
        HttpStatus httpStatus = e.getHttpStatus();
        return new ResponseEntity<>(new ResponseMessage(errorMessage),new HttpHeaders(), httpStatus);
    }

}
