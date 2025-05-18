package com.neighbourly.commonservice.errorhandling.exceptions;

public class ValidationException extends CommonException {
    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}