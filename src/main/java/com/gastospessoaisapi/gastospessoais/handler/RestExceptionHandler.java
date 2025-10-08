package com.gastospessoaisapi.gastospessoais.handler;

import com.gastospessoaisapi.gastospessoais.common.DateConverter;
import com.gastospessoaisapi.gastospessoais.domain.exceptions.ResourceBadRequestException;
import com.gastospessoaisapi.gastospessoais.domain.exceptions.ResourceNotFoundException;
import com.gastospessoaisapi.gastospessoais.domain.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            DateConverter.convertDateToString(new Date()),
            "404",
            "Resource Not Found",
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceBadRequestException.class)
    public ResponseEntity<ErrorResponse> handleResourceBadRequestException(ResourceBadRequestException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
            DateConverter.convertDateToString(new Date()),
            "400",
            "Bad Request",
            ex.getMessage()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
