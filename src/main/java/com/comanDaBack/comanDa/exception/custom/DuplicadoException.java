package com.comanDaBack.comanDa.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicadoException extends RuntimeException {
    public DuplicadoException(String message) {
        super(message);
    }
}
