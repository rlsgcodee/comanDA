package com.comanDaBack.comanDa.security.exception.handler;


import com.comanDaBack.comanDa.security.exception.custom.UserAlreadyExistsException;
import com.comanDaBack.comanDa.security.exception.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO>  runtimeExceptionHandler(RuntimeException ex){
        ErrorDTO error = new ErrorDTO("400", ex.getMessage());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
}
