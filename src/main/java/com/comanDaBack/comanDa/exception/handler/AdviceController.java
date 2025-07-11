package com.comanDaBack.comanDa.exception.handler;


import com.comanDaBack.comanDa.exception.custom.DuplicadoException;
import com.comanDaBack.comanDa.exception.custom.NotFoundException;
import com.comanDaBack.comanDa.exception.error.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<ErrorDTO> categoriaNotFoundException(NotFoundException ex){
        ErrorDTO error = new ErrorDTO("400", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = DuplicadoException.class)
    public ResponseEntity<ErrorDTO> duplicadoException(DuplicadoException ex){
        ErrorDTO error = new ErrorDTO("409", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
}
