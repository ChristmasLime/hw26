package com.homework26.homework26.exception;

public class ElementNoFoundException extends RuntimeException {
    public ElementNoFoundException() {
    }

    public ElementNoFoundException(String message) {
        super(message);
    }

    public ElementNoFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementNoFoundException(Throwable cause) {
        super(cause);
    }

    public ElementNoFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
