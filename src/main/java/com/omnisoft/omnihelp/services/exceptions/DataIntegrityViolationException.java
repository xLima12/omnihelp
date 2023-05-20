package com.omnisoft.omnihelp.services.exceptions;

public class DataIntegrityViolationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    // Constructors
    public DataIntegrityViolationException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataIntegrityViolationException(String message) {
        super(message);
    }

}
