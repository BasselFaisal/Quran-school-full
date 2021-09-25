package com.quranSchool.backcend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = -8288509719643846690L;

	private String message;

    public BadRequestException(String message) {
        super(String.format(message));
    }
}
