package com.quranschool.configuration.exception;

import com.quranschool.coreModule.models.response.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    public ResponseEntity getExceptionResponse(String ex, HttpStatus status){
        Response response = new Response(ex);
        return new ResponseEntity(response, status);
    }

}
