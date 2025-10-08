package com.gastospessoaisapi.gastospessoais.domain.exceptions;

public class ResourceBadRequestException extends RuntimeException {
    public ResourceBadRequestException(String message) {
        super(message);
    }
}
