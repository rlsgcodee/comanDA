package com.comanDaBack.comanDa.security.exception.custom;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserAlreadyExistsException  extends RuntimeException{
    public UserAlreadyExistsException(String msg){
        super(msg);
    }
}
