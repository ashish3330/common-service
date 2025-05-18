package com.neighbourly.commonservice.errorhandling.exceptions;

public class NotFoundException extends CommonException {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}