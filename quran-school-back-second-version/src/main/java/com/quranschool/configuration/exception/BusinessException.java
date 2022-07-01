package com.quranschool.configuration.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BusinessException extends RuntimeException{

    private static final Long serialVersionUID = 1L;
    private String message;

    public BusinessException(String message){
        super(String.format(message));
    }

}
