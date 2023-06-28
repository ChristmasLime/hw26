package com.homework26.homework26.exception;

public class ItemCannotBeNullException extends RuntimeException{

    public ItemCannotBeNullException() {
    }

    public ItemCannotBeNullException(String message) {
        super(message);
    }

    public ItemCannotBeNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ItemCannotBeNullException(Throwable cause) {
        super(cause);
    }

    public ItemCannotBeNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
