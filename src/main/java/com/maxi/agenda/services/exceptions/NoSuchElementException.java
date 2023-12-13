package com.maxi.agenda.services.exceptions;

public class NoSuchElementException extends RuntimeException {

    public NoSuchElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchElementException(String message) {
        super(message);
    }
}
